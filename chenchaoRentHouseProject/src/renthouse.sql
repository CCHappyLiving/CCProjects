drop table if exists DISTRICT;

drop table if exists HOUSE;

drop table if exists HOUSE_PICTURE;

drop table if exists HOUSE_TYPE;

drop table if exists HOUSE_USER;

drop table if exists STREET;

/*==============================================================*/
/* Table: DISTRICT                                              */
/*==============================================================*/
create table DISTRICT
(
   ID                   int not null,
   NAME                 varchar(50),
   primary key (ID)
);

alter table DISTRICT comment '城区表';

/*==============================================================*/
/* Table: HOUSE                                                 */
/*==============================================================*/
create table HOUSE
(
   ID                   int not null,
   USER_ID              int,
   TYPE_ID              int,
   TITLE                varchar(50),
   DESCRIPTION          varchar(2000),
   PRICE                double,
   PUBDATE              date,
   ADDDATE              date,
   FLOORAGE             float,
   CONTACT              varchar(100),
   STREET_ID            int,
   primary key (ID)
);

alter table HOUSE comment '房屋表';

/*==============================================================*/
/* Table: HOUSE_PICTURE                                         */
/*==============================================================*/
create table HOUSE_PICTURE
(
   ID                   int not null,
   HOUSE_ID             int,
   TITLE                varchar(50),
   URL                  varchar(500),
   primary key (ID)
);

alter table HOUSE_PICTURE comment '图片表';

/*==============================================================*/
/* Table: HOUSE_TYPE                                            */
/*==============================================================*/
create table HOUSE_TYPE
(
   ID                   int not null,
   NAME                 varchar(50),
   primary key (ID)
);

alter table HOUSE_TYPE comment '房屋类型表';

/*==============================================================*/
/* Table: HOUSE_USER                                            */
/*==============================================================*/
create table HOUSE_USER
(
   ID                   int not null,
   USERNAME             varchar(1),
   PASSWORD             varchar(50),
   TELEPHONE            varchar(15),
   REALNAME             varchar(50),
   ISADMIN              varchar(5),
   primary key (ID)
);

alter table HOUSE_USER comment '用户信息表';

/*==============================================================*/
/* Table: STREET                                                */
/*==============================================================*/
create table STREET
(
   ID                   int not null,
   NAME                 varchar(50),
   DISTRICT_ID          int,
   primary key (ID)
);

alter table HOUSE_USER comment '街道表';


alter table HOUSE add constraint FK_FK_HOUSE_USER foreign key (USER_ID)
      references HOUSE_USER (ID) on delete restrict on update restrict;

alter table HOUSE add constraint FK_FK_STREET_ID foreign key (STREET_ID)
      references STREET (ID) on delete restrict on update restrict;

alter table HOUSE add constraint FK_FK_TYPE_ID foreign key (TYPE_ID)
      references HOUSE_TYPE (ID) on delete restrict on update restrict;

alter table HOUSE_PICTURE add constraint FK_FK_HOUSE_PICTURE foreign key (HOUSE_ID)
      references HOUSE (ID) on delete restrict on update restrict;

alter table STREET add constraint FK_FK_DISTRICT_ID foreign key (DISTRICT_ID)
      references DISTRICT (ID) on delete restrict on update restrict;
