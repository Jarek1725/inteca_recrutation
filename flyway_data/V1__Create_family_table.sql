    create table family (
       family_id  serial not null,
        adults_number int4,
        children_number int4,
        family_name varchar(255),
        infants_number int4,
        primary key (family_id)
    );
    

        create table family_member (
       family_member_id  serial not null,
        age int4,
        given_name varchar(255),
        family int4,
        primary key (family_member_id)
    )


