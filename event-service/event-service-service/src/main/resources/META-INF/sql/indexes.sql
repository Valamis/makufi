create index IX_19E72501 on Calendar_Event (eventFriendlyName[$COLUMN_LENGTH:1000$]);
create index IX_306AD67 on Calendar_Event (startingDate, companyId);
create index IX_5DE85F43 on Calendar_Event (status[$COLUMN_LENGTH:75$], companyId);
create index IX_4BEBC7A on Calendar_Event (status[$COLUMN_LENGTH:75$], endingDate, companyId);
create index IX_6DEE4C41 on Calendar_Event (status[$COLUMN_LENGTH:75$], startingDate, companyId);
create index IX_E8158013 on Calendar_Event (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9314EF55 on Calendar_Event (uuid_[$COLUMN_LENGTH:75$], groupId);