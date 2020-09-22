package com.example.mycalendarapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Calendars;
import android.text.format.DateUtils;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    //カレンダー情報保持
    ArrayList<MyCalendar> myCalArray = new ArrayList<>();
    MyCalendar myCal;

    //イベント情報保持
    ArrayList<MyCalendarEvent> myCalEventArray = new ArrayList<>();
    MyCalendarEvent myCalEvent;

    // 取得したいいカラープロパティの一覧を指定する。
    private static final String[] COLOR_PROJECTION = new String[] {
            Colors._ID,
            Colors.COLOR,
            Colors.COLOR_KEY,
            Colors.COLOR_TYPE,
            Colors.ACCOUNT_NAME,
            Colors.ACCOUNT_TYPE,
    };

    // カラープロジェクション配列のインデックス
    private static final int COLOR_PROJECTION_IDX_ID = 0;
    private static final int COLOR_PROJECTION_IDX_COLOR = 1;
    private static final int COLOR_PROJECTION_IDX_COLOR_KEY = 2;
    private static final int COLOR_PROJECTION_IDX_COLOR_TYPE = 3;
    private static final int COLOR_PROJECTION_IDX_ACCOUNT_NAME = 4;
    private static final int COLOR_PROJECTION_IDX_ACCOUNT_TYPE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getCalendarList();
        for (int i = 0; i < myCalArray.size(); i++){
            this.getCalendarEvent(myCalArray.get(i).getId());
        }

        this.getColorList(myCalArray.get(0).getAccountName(), myCalArray.get(0).getAccountType());

        //イベント追加してみる
        final long calendarId = 1;
        final String eventColorKey = "4";

//        final long now = new Date().getTime()+ 60 * 60 * 1000 * 24;
//        final long anHourLater = now + 60 * 60 * 1000;
//        long eventId = this.addEvent(calendarId, "イベントタイトル", "イベントの説明", eventColorKey, now, anHourLater);

        long now = 1600853682000l;
        long anHourLater = 1600857282000l;
        long eventId = this.addEvent(calendarId, "イベントタイトル", "イベントの説明", eventColorKey, now, anHourLater);
        Log.d("TAG","eventId: " + eventId);

    }

    public void getCalendarList() {
        myCal = new MyCalendar();

        // クエリ条件を設定する
        final Uri uri = Calendars.CONTENT_URI;
//        Log.d("TAG", "uri:" + uri);
        final String[] projection = MyCalendar.CALENDAR_PROJECTION;
        final String selection = null;
        final String[] selectionArgs = null;
        final String sortOrder = null;

        // クエリを発行してカーソルを取得する
        final ContentResolver cr = getContentResolver();
        final Cursor cur = cr.query(uri, projection, selection, selectionArgs, sortOrder);

        // ログ出力 (Header)
        final StringBuilder sbHeader = new StringBuilder();
        for (final String property : MyCalendar.CALENDAR_PROJECTION) {
            sbHeader.append(property).append(',');
        }
        Log.d("TAG", sbHeader.toString());

        while (cur.moveToNext()) {
//            String columnName[] = cur.getColumnNames();
//            Log.d("TAG","getCalendarColumnNames: " + Arrays.toString(columnName));

            // カーソルから各プロパティを取得する
            myCal = new MyCalendar();
            myCal.setId(cur.getLong(MyCalendar.CALENDAR_PROJECTION_IDX_ID));
            myCal.setName(cur.getString(MyCalendar.CALENDAR_PROJECTION_IDX_NAME));
            myCal.setAccountName(cur.getString(MyCalendar.CALENDAR_PROJECTION_IDX_ACCOUNT_NAME));
            myCal.setAccountType(cur.getString(MyCalendar.CALENDAR_PROJECTION_IDX_ACCOUNT_TYPE));
            myCal.setCalendarColor(cur.getInt(MyCalendar.CALENDAR_PROJECTION_IDX_CALENDAR_COLOR));
            myCal.setCalendarDisplayName(cur.getString(MyCalendar.CALENDAR_PROJECTION_IDX_CALENDAR_DISPLAY_NAME));
            myCal.setCalendarAccessLevel(cur.getInt(MyCalendar.CALENDAR_PROJECTION_IDX_CALENDAR_ACCESS_LEVEL));
            myCal.setCalendarTimeZone(cur.getString(MyCalendar.CALENDAR_PROJECTION_IDX_CALENDAR_TIME_ZONE));
            myCal.setVisible(cur.getInt(MyCalendar.CALENDAR_PROJECTION_IDX_VISIBLE));
            myCal.setSyncEvents(cur.getInt(MyCalendar.CALENDAR_PROJECTION_IDX_SYNC_EVENTS));
            myCal.setOwnerAccount(cur.getString(MyCalendar.CALENDAR_PROJECTION_IDX_OWNER_ACCOUNT));
            myCalArray.add(myCal);

            // ログ出力
            myCal.outLog();
        }

    }

    public void getCalendarEvent(Long calendarId) {

        // 検索対象のカレンダーの _ID
        final long targetCalendarId = calendarId;
        Log.d("TAG", "targetEventCalendarId:" + targetCalendarId);

        // クエリ条件を設定する
        final Uri uri = Events.CONTENT_URI;
//        Log.d("TAG", "uri:" + uri);
        final String[] projection = MyCalendarEvent.EVENT_PROJECTION;
        final String selection = "(" + Events.CALENDAR_ID + " = ?)";
        final String[] selectionArgs = new String[] {String.valueOf(targetCalendarId)};
        final String sortOrder = null;

        // クエリを発行してカーソルを取得する
        final ContentResolver cr = getContentResolver();
        final Cursor cur = cr.query(uri, projection, selection, selectionArgs, sortOrder);

        // ログ出力 (Header)
        final StringBuilder sbEvents = new StringBuilder();
        for (final String property : MyCalendarEvent.EVENT_PROJECTION) {
            sbEvents.append(property).append(',');
        }
        Log.d("TAG", sbEvents.toString());

        while (cur.moveToNext()) {
//            String columnName[] = cur.getColumnNames();
//            Log.d("TAG","getEventColumnNames: " + Arrays.toString(columnName));
            // カーソルから各プロパティを取得する
            myCalEvent = new MyCalendarEvent();
            myCalEvent.setCalendarId(cur.getLong(MyCalendarEvent.EVENT_PROJECTION_IDX_CALENDAR_ID));
            myCalEvent.setTitle(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_TITLE));
            myCalEvent.setDescription(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_DESCRIPTION));
            myCalEvent.setEventLocation(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_EVENT_LOCATION));
            myCalEvent.setEventColor(cur.getInt(MyCalendarEvent.EVENT_PROJECTION_IDX_EVENT_COLOR));
            myCalEvent.setDtstart(cur.getLong(MyCalendarEvent.EVENT_PROJECTION_IDX_DTSTART));
            myCalEvent.setDtend(cur.getLong(MyCalendarEvent.EVENT_PROJECTION_IDX_DTEND));
            myCalEvent.setDuration(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_DURATION));
            myCalEvent.setEventTimeZone(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_EVENT_TIMEZONE));
            myCalEvent.setEventEndTimeZone(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_EVENT_END_TIMEZONE));
            myCalEvent.setAllDay(cur.getInt(MyCalendarEvent.EVENT_PROJECTION_IDX_ALL_DAY));
            myCalEvent.setrRule(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_RRULE));
            myCalEvent.setrDate(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_RDATE));
            myCalEvent.setGuestsCanModify(cur.getInt(MyCalendarEvent.EVENT_PROJECTION_IDX_GUESTS_CAN_MODIFY));
            myCalEvent.setGuestsCanInviteOthers(cur.getInt(MyCalendarEvent.EVENT_PROJECTION_IDX_GUESTS_CAN_INVITE_OTHERS));
            myCalEvent.setGuestsCanSeeGuests(cur.getInt(MyCalendarEvent.EVENT_PROJECTION_IDX_GUESTS_CAN_SEE_GUESTS));
            myCalEvent.setOrganizer(cur.getString(MyCalendarEvent.EVENT_PROJECTION_IDX_ORGANIZER));
            myCalEventArray.add(myCalEvent);
            // ログ出力
            myCalEvent.outLog();
        }
    }

    public void getColorList(final String accountName, final String accountType) {
        // クエリ条件を設定する
        final Uri uri = Colors.CONTENT_URI;
        final String[] projection = COLOR_PROJECTION;
        // 特定のアカウントで、イベントの色情報を持つレコードのみを対象とする
        final String selection =
                "((" + Colors.ACCOUNT_NAME + " = ?)"
                        + "AND (" + Colors.ACCOUNT_TYPE + " = ?)"
                        + "AND (" + Colors.COLOR_TYPE + " = ?))";
        final String[] selectionArgs = new String[] {
                accountName,
                accountType,
                String.valueOf(Colors.TYPE_EVENT),
        };
        final String sortOrder = null;

        // クエリを発行してカーソルを取得する
        final ContentResolver cr = getContentResolver();
        final Cursor cur = cr.query(uri, projection, selection, selectionArgs, sortOrder);

        while (cur.moveToNext()) {
//            String columnName[] = cur.getColumnNames();
//            Log.d("TAG","getColorColumnNames: " + Arrays.toString(columnName));
            // カーソルから各プロパティを取得する
            final long id = cur.getLong(COLOR_PROJECTION_IDX_ID);
            final int color = cur.getInt(COLOR_PROJECTION_IDX_COLOR);
            final String colorKey = cur.getString(COLOR_PROJECTION_IDX_COLOR_KEY);
            final String colorType = cur.getString(COLOR_PROJECTION_IDX_COLOR_TYPE);

            // ログ出力 (Body)
            final StringBuilder sbBody = new StringBuilder();
            sbBody.append(id).append(',');
            sbBody.append(color).append(',');
            sbBody.append(colorKey).append(',');
            sbBody.append(colorType).append(',');
            Log.d("TAG", sbBody.toString());
        }
    }


    private long addEvent(
        final long calendarId,
        final String title,
        final String description,
        final String colorKey,
        final long startMillis,
        final long endMillis
    ){
        final ContentResolver cr = getContentResolver();

        final ContentValues values = new ContentValues();
        values.put(Events.CALENDAR_ID, calendarId);
        values.put(Events.TITLE, title);
        values.put(Events.DESCRIPTION, description);
        values.put(Events.EVENT_COLOR_KEY, colorKey);
        values.put(Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
        values.put(Events.DTSTART, startMillis);
        values.put(Events.DTEND, endMillis);

        final Uri uri = cr.insert(Events.CONTENT_URI, values);

        final long eventId = Long.parseLong(uri.getLastPathSegment());
        return eventId;
    }

    //UNIX time (1970/01/01 00:00:00からの経過時刻[msec])を文字列化
    private static String getDateTimeText(
            final Context context,
            final String timeZone,
            final long dateTimeInMillis
    ) {
        final Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(dateTimeInMillis);
        return DateUtils.formatDateRange(context, new java.util.Formatter(), calendar.getTimeInMillis(), calendar.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR, timeZone).toString();
    }
}