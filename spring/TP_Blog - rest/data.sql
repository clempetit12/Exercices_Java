CREATE TABLE IF NOT EXISTS post (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    content TEXT,
                                    description TEXT,
                                    image_url VARCHAR(255),
    title VARCHAR(255),
    date DATE
    );



INSERT INTO post (content, description, image_url, title, date)
VALUES
    ('Contenu de l''article 1', 'Description de l''article 1', 'tim-swaan-eOpewngf68w-unsplash.jpg', 'Titre de l''article 1', '2024-04-10'),
    ('Contenu de l''article 2', 'Description de l''article 2', 'qingbao-meng-01_igFr7hd4-unsplash.jpg', 'Titre de l''article 2', '2024-04-11'),
    ('Soleil', 'Bucolique', 'oc-gonzalez-xg8z_KhSorQ-unsplash.jpg', 'Titre de l''article 3', '2024-04-12');


CREATE TABLE IF NOT EXISTS users (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    role VARCHAR(255),
                                    password VARCHAR(255),
                                    email VARCHAR(255)

    );

INSERT INTO users (email, password, role)
VALUES
    ('admin@gmail.com', 'admin', 'ADMIN_ROLE');

SELECT * FROM user WHERE email = 'admin@gmail.com';

