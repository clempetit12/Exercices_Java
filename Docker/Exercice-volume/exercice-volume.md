1) créer un serveur web avec un site web personnalisé qui utilisera comme technologie apache 
2) On veut finalement déployer avec nginx mais toujours le meme site web 



PS C:\Users\Administrateur> docker volume create monsiteweb
monsiteweb
PS C:\Users\Administrateur> docker volume ls
DRIVER    VOLUME NAME
local     monsiteweb
local     monweb
local     mydata

PS C:\Users\Administrateur>  docker run --nameserverweb -d -p 8080:80  -v siteweb:/usr/local/apache2/htdocs/  httpd  => il faut aller voir dans la doc de httpd pour savoir où soller sans docker files


PS C:\Users\Administrateur> docker start cool_beaver
cool_beaver
PS C:\Users\Administrateur> docker exec -it cool_beaver sh


PS C:\Users\Administrateur>  docker cp C:\Users\Administrateur\Desktop\Exercices_Java\Docker\Exercice-volume\website\. serverweb:/usr/local/apache2/htdocs/
Successfully copied 3.34MB to serverweb:/usr/local/apache2/htdocs/ (il faut mettre l'antislash pour avoir le contenu du dossier copié)

PS C:\Users\Administrateur> docker ps
CONTAINER ID   IMAGE     COMMAND              CREATED          STATUS         PORTS     NAMES
e66b8eec7c5c   httpd     "httpd-foreground"   11 minutes ago   Up 7 minutes   80/tcp    cool_beaver

PS C:\Users\Administrateur> docker stop cool_beaver
cool_beaver

PS C:\Users\Administrateur> docker rm cool_beaver
cool_beaver

PS C:\Users\Administrateur> docker run -v monsiteweb:/root -it nginx

PS C:\Users\Administrateur> docker start heuristic_borg
heuristic_borg
PS C:\Users\Administrateur> docker exec -it heuristic_borg sh
# cd root
# ls
html5up-editorial-m2i.zip
# apk upgrade

# apt upgrade

# apt update


# apt install unzip

# unzip html5up-editorial-m2i -d .

# exit
