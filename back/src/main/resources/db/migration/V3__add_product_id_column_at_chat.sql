alter table Chat
    add column product_id bigint not null;

alter table chat
    add constraint chat_product_fk
        foreign key (product_id) references Product;

