package com.example.mycalendarapplication;

import android.provider.CalendarContract;
import android.util.Log;

/**
 * イベント情報保持クラス
 */
public class MyCalendarEvent {

    public static final String[] EVENT_PROJECTION = new String[] {
            CalendarContract.Events.CALENDAR_ID,
            CalendarContract.Events.TITLE,
            CalendarContract.Events.DESCRIPTION,
            CalendarContract.Events.EVENT_LOCATION,
            CalendarContract.Events.EVENT_COLOR,
            CalendarContract.Events.DISPLAY_COLOR,
            CalendarContract.Events.DTSTART,
            CalendarContract.Events.DTEND,
            CalendarContract.Events.DURATION,
            CalendarContract.Events.EVENT_TIMEZONE,
            CalendarContract.Events.EVENT_END_TIMEZONE,
            CalendarContract.Events.ALL_DAY,
            CalendarContract.Events.RRULE,
            CalendarContract.Events.RDATE,
            CalendarContract.Events.GUESTS_CAN_MODIFY,
            CalendarContract.Events.GUESTS_CAN_INVITE_OTHERS,
            CalendarContract.Events.GUESTS_CAN_SEE_GUESTS,
            CalendarContract.Events.ORGANIZER,
    };
    // イベントプロジェクション配列のインデックス。
    public static final int EVENT_PROJECTION_IDX_CALENDAR_ID = 0;
    public static final int EVENT_PROJECTION_IDX_TITLE = 1;
    public static final int EVENT_PROJECTION_IDX_DESCRIPTION = 2;
    public static final int EVENT_PROJECTION_IDX_EVENT_LOCATION = 3;
    public static final int EVENT_PROJECTION_IDX_EVENT_COLOR = 4;
    public static final int EVENT_PROJECTION_IDX_DISPLAY_COLOR = 5;
    public static final int EVENT_PROJECTION_IDX_DTSTART = 6;
    public static final int EVENT_PROJECTION_IDX_DTEND = 7;
    public static final int EVENT_PROJECTION_IDX_DURATION = 8;
    public static final int EVENT_PROJECTION_IDX_EVENT_TIMEZONE = 9;
    public static final int EVENT_PROJECTION_IDX_EVENT_END_TIMEZONE = 10;
    public static final int EVENT_PROJECTION_IDX_ALL_DAY = 11;
    public static final int EVENT_PROJECTION_IDX_RRULE = 12;
    public static final int EVENT_PROJECTION_IDX_RDATE = 13;
    public static final int EVENT_PROJECTION_IDX_GUESTS_CAN_MODIFY = 14;
    public static final int EVENT_PROJECTION_IDX_GUESTS_CAN_INVITE_OTHERS = 15;
    public static final int EVENT_PROJECTION_IDX_GUESTS_CAN_SEE_GUESTS = 16;
    public static final int EVENT_PROJECTION_IDX_ORGANIZER = 17;

    long calendarId;
    String title;
    String description;
    String eventLocation;
    int eventColor;
    int displayColor;
    long dtStart;
    long dtEnd;
    String duration;
    String eventTimeZone;
    String eventEndTimeZone;
    int allDay;
    String rRule;
    String rDate;
    int guestsCanModify;
    int guestsCanInviteOthers;
    int guestsCanSeeGuests;
    String organizer;

    public void outLog() {
        final StringBuilder sbBody = new StringBuilder();
        //sbBody.append(id).append(',');
        sbBody.append(calendarId).append(',');
        sbBody.append(title).append(',');
        sbBody.append(description).append(',');
        sbBody.append(eventLocation).append(',');
        sbBody.append(eventColor).append(',');
        sbBody.append(displayColor).append(',');
        sbBody.append(dtStart).append(',');
        sbBody.append(dtEnd).append(',');
        sbBody.append(duration).append(',');
        sbBody.append(eventTimeZone).append(',');
        sbBody.append(eventEndTimeZone).append(',');
        sbBody.append(allDay).append(',');
        sbBody.append(rRule).append(',');
        sbBody.append(rDate).append(',');
        sbBody.append(guestsCanModify).append(',');
        sbBody.append(guestsCanInviteOthers).append(',');
        sbBody.append(guestsCanSeeGuests).append(',');
        sbBody.append(organizer).append(',');
        Log.d("TAG", sbBody.toString());
    }

    public long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(long calendarId) {
        this.calendarId = calendarId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public int getEventColor() {
        return eventColor;
    }

    public void setEventColor(int eventColor) {
        this.eventColor = eventColor;
    }

    public int getDisplayColor() {
        return displayColor;
    }

    public void setDisplayColor(int displayColor) {
        this.displayColor = displayColor;
    }

    public long getDtStart() {
        return dtStart;
    }

    public void setDtstart(long dtstart) {
        this.dtStart = dtstart;
    }

    public long getDtend() {
        return dtEnd;
    }

    public void setDtend(long dtend) {
        this.dtEnd = dtend;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEventTimeZone() {
        return eventTimeZone;
    }

    public void setEventTimeZone(String eventTimeZone) {
        this.eventTimeZone = eventTimeZone;
    }

    public String getEventEndTimeZone() {
        return eventEndTimeZone;
    }

    public void setEventEndTimeZone(String eventEndTimeZone) {
        this.eventEndTimeZone = eventEndTimeZone;
    }

    public int getAllDay() {
        return allDay;
    }

    public void setAllDay(int allDay) {
        this.allDay = allDay;
    }

    public String getrRule() {
        return rRule;
    }

    public void setrRule(String rRule) {
        this.rRule = rRule;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public int getGuestsCanModify() {
        return guestsCanModify;
    }

    public void setGuestsCanModify(int guestsCanModify) {
        this.guestsCanModify = guestsCanModify;
    }

    public int getGuestsCanInviteOthers() {
        return guestsCanInviteOthers;
    }

    public void setGuestsCanInviteOthers(int guestsCanInviteOthers) {
        this.guestsCanInviteOthers = guestsCanInviteOthers;
    }

    public int getGuestsCanSeeGuests() {
        return guestsCanSeeGuests;
    }

    public void setGuestsCanSeeGuests(int guestsCanSeeGuests) {
        this.guestsCanSeeGuests = guestsCanSeeGuests;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
}

