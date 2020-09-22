package com.example.mycalendarapplication;

import android.provider.CalendarContract;
import android.util.Log;

/*
カレンダー情報保持クラス
 */
public class MyCalendar {

    // プロジェクション配列。
    // 取得したいカレンダプロパティの一覧を指定する。
    public static final String[] CALENDAR_PROJECTION = new String[] {
            CalendarContract.Calendars._ID,
            CalendarContract.Calendars.NAME,
            CalendarContract.Calendars.ACCOUNT_NAME,
            CalendarContract.Calendars.ACCOUNT_TYPE,
            CalendarContract.Calendars.CALENDAR_COLOR,
            CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
            CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL,
            CalendarContract.Calendars.CALENDAR_TIME_ZONE,
            CalendarContract.Calendars.VISIBLE,
            CalendarContract.Calendars.SYNC_EVENTS,
            CalendarContract.Calendars.OWNER_ACCOUNT,
    };

    // カレンダープロジェクション配列のインデックス。
    // パフォーマンス向上のために、動的に取得せずに、静的に定義しておく。
    public static final int CALENDAR_PROJECTION_IDX_ID = 0;
    public static final int CALENDAR_PROJECTION_IDX_NAME = 1;
    public static final int CALENDAR_PROJECTION_IDX_ACCOUNT_NAME = 2;
    public static final int CALENDAR_PROJECTION_IDX_ACCOUNT_TYPE = 3;
    public static final int CALENDAR_PROJECTION_IDX_CALENDAR_COLOR = 4;
    public static final int CALENDAR_PROJECTION_IDX_CALENDAR_DISPLAY_NAME = 5;
    public static final int CALENDAR_PROJECTION_IDX_CALENDAR_ACCESS_LEVEL = 6;
    public static final int CALENDAR_PROJECTION_IDX_CALENDAR_TIME_ZONE = 7;
    public static final int CALENDAR_PROJECTION_IDX_VISIBLE = 8;
    public static final int CALENDAR_PROJECTION_IDX_SYNC_EVENTS = 9;
    public static final int CALENDAR_PROJECTION_IDX_OWNER_ACCOUNT = 10;

    private long id;
    private String name;
    private String accountName;
    private String accountType;
    private int calendarColor;
    private String calendarDisplayName;
    private int calendarAccessLevel;
    private String calendarTimeZone;
    private int visible;
    private int syncEvents;
    private String ownerAccount;

    public void outLog() {
        final StringBuilder sbBody = new StringBuilder();
        sbBody.append(id).append(',');
        sbBody.append(name).append(',');
        sbBody.append(accountName).append(',');
        sbBody.append(accountType).append(',');
        sbBody.append(String.format("0x%08X", calendarColor)).append(',');
        sbBody.append(calendarDisplayName).append(',');
        sbBody.append(calendarAccessLevel).append(',');
        sbBody.append(calendarTimeZone).append(',');
        sbBody.append(visible).append(',');
        sbBody.append(syncEvents).append(',');
        sbBody.append(ownerAccount).append(',');
        Log.d("TAG", sbBody.toString());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getCalendarColor() {
        return calendarColor;
    }

    public void setCalendarColor(int calendarColor) {
        this.calendarColor = calendarColor;
    }

    public String getCalendarDisplayName() {
        return calendarDisplayName;
    }

    public void setCalendarDisplayName(String calendarDisplayName) {
        this.calendarDisplayName = calendarDisplayName;
    }

    public int getCalendarAccessLevel() {
        return calendarAccessLevel;
    }

    public void setCalendarAccessLevel(int calendarAccessLevel) {
        this.calendarAccessLevel = calendarAccessLevel;
    }

    public String getCalendarTimeZone() {
        return calendarTimeZone;
    }

    public void setCalendarTimeZone(String calendarTimeZone) {
        this.calendarTimeZone = calendarTimeZone;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getSyncEvents() {
        return syncEvents;
    }

    public void setSyncEvents(int syncEvents) {
        this.syncEvents = syncEvents;
    }

    public String getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(String ownerAccount) {
        this.ownerAccount = ownerAccount;
    }
}
