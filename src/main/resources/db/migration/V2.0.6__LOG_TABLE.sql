CREATE TABLE IF NOT EXISTS api_logs (
    id BIGSERIAL PRIMARY KEY,
    http_method VARCHAR(10) ,
    endpoint VARCHAR(255) ,
    status_code INT ,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create sequence sq_api_logs
    minvalue 1
    maxvalue 999999999999
    start with 1
    increment by 1 cache 10
    cycle;
