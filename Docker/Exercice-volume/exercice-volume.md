1) créer un serveur web avec un site web personnalisé qui utilisera comme technologie apache 
2) On veut finalement déployer avec nginx mais toujours le meme site web 



PS C:\Users\Administrateur> docker volume create monsiteweb
monsiteweb
PS C:\Users\Administrateur> docker volume ls
DRIVER    VOLUME NAME
local     monsiteweb
local     monweb
local     mydata

PS C:\Users\Administrateur> docker run -v monsiteweb:/root -it httpd
AH00558: httpd: Could not reliably determine the server's fully qualified domain name, using 172.17.0.2. Set the 'ServerName' directive globally to suppress this message
AH00558: httpd: Could not reliably determine the server's fully qualified domain name, using 172.17.0.2. Set the 'ServerName' directive globally to suppress this message
[Tue Mar 26 16:02:16.274490 2024] [mpm_event:notice] [pid 1:tid 139646519584640] AH00489: Apache/2.4.58 (Unix) configured -- resuming normal operations
[Tue Mar 26 16:02:16.274588 2024] [core:notice] [pid 1:tid 139646519584640] AH00094: Command line: 'httpd -D FOREGROUND'


PS C:\Users\Administrateur> docker start cool_beaver
cool_beaver
PS C:\Users\Administrateur> docker exec -it cool_beaver sh


PS C:\Users\Administrateur> docker cp C:\Users\Administrateur\Desktop\CDA_LILLE_17_JUILLET\docker\exercice\files_tp_conteneur\html5up-editorial-m2i.zip cool_beaver:\root
Successfully copied 1.72MB to cool_beaver:\root

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
