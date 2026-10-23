create table expense (
    id SERIAL PRIMARY KEY, description VARCHAR(255), amount DOUBLE PRECISION, paid_by_user_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)