# Aviso - Warning!
Br: Eu estarei usando o meu idioma nativo para descrever esse projeto, então caso você não esteja entendendo nada que estou digitando, utilize o tradutor do seu navegador. Obrigado!<br></br>
En: I'll be using my native language to describe this project, so if you don't understand anything I'm typing, use your browser's translator.  Thank you!

Obrigado ao @LGL, pelo layout e templates!
Obrigado a todos pelo apoio!

Contatc Telegram @Hyupai
 
 **Eu ja postei uma versão parecida com esta, entretando com o flutuante separado:https://github.com/Hyupai/Login-Java-Php-Mysql-Android**<br>
 **Antes que me perguntem o porque não puis a validade no flutuante é por que estava tendo alguns problemas.**
 
# Programas necessários
- Android Studio/AIDE (eu recomendo o AndroidStudio)
- Apk Easy Tool
- Um servidor web com suporte para PHP
- Esse projeto

# Server

Muitas pessoas estão tendo dificuldades com o Server, então simplesmente assista ao video que eu deixei.
Eu fiz um pequeno upgrade com relaçao ao sistema de exibiçao de usuarios. E inclemente nele uma tela de consultas. Assim não sera necessario passar seu painel de administrador ao Usuario.

Estarei deixando ele em Zip, mas no meu eu tirei o RegisterUser por questoes de segurança.

Caso nao esteja entendendo essa parte eu ensinei um pouco nesse video:https://youtu.be/jAgDdB7gw7A

# Editando seu projeto

Primeiro de tudo modifique sua URLSERVER na **Auth.java**, verifique sempre o http(s).<br><br>
![](https://i.imgur.com/5q2IDZX.png)<br></br>
Modifique também o layout se quiser na **MainActivity.java**, lembre-se que o título está em base 64 para evitar leechs.<br></br>
![](https://i.imgur.com/yb78gLU.png)<br></br>
Modifique as URLS para o canal do Youtube e tambem para a pagina de consulta.<br></br>
![](https://i.imgur.com/2wPZbjP.png)<br></br>
**Para modificar o flutuante acesse:https://github.com/LGLTeam/Android-Mod-Menu**<br></br>
Se você tiver usando o AIDE, verifique se o NDK está compilando corretamente a lib. (Eu tive problemas com isso)<br></br>
Agora,descubra a MainActivity do seu jogo.

Utilize o Apk Tool para vê-la:

![](https://i.imgur.com/JQdPjyZ.png)

Nesse caso está como `com.unity3d.player.UnityPlayerActivity`


No android studio ou AIDE modifique a `public String sGameActivity` se necessário!

![](https://i.imgur.com/KBBek2N.png)

Construa seu apk:

**Build** -> **Build Bundle(s)/APK(s)** -> **Build APK(s)**

Se tudo correr bem você será notificado.

![](https://i.imgur.com/WpSKV1L.png)

Clique em **locate** para mostrar o local do **build.apk**. 
![](https://i.imgur.com/wBTPSLi.png) 

# Implementando seu projeto no jogo

Agora decompile **app-debug.apk**.

Copie seu smali app-debug.apk descompilado para a pasta smali do jogo. O nosso exemplo é uk.lgl.modmenu, copiaríamos a pasta `uk`e `a` (se tiver) de` (app-debug \ smali \ uk) `para o diretório descompilado do jogo` (nome do jogo) \ smali`. Se o jogo tiver multidexes, adicione seu smali às últimas classes dex se possível para evitar erros de compilação.

Na manifest do jogo `androidmanifest.xml`, fique claro que as seguintes permissoes exista: <br>`<uses-permission android:name="android.permission.INTERNET"/>`<br>`<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />`<br>
`<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>`<br>
`<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />`<br>
Caso não exista adicione-as.


![](https://i.imgur.com/k0sLVUF.png)

Agora localize a Activity Principal do jogo que você obteve anteriormente dentro da Android Manifest e depois remova:
`<action android:name="android.intent.action.MAIN"/>` desse jeito.

![](https://i.imgur.com/z1RxPjc.png)

Antes do fim da tag de Aplication, Adicione suas activitys `</application>`. `com.uk.lgl.MainActivity` é sua activity principal.

```xml
<activity android:configChanges="keyboardHidden|orientation|screenSize" android:name="uk.lgl.modmenu.MainActivity" android:screenOrientation="portrait">
     <intent-filter>
         <action android:name="android.intent.action.MAIN"/>
         <category android:name="android.intent.category.LAUNCHER"/>
     </intent-filter>
</activity>
```
**Adicione tambem:**<br>
```xml
<activity android:configChanges="keyboardHidden|orientation|screenSize" android:name="uk.lgl.modmeny.MainActivity2" android:screenOrientation="portrait">
     <intent-filter>
         <category android:name="android.intent.category.LAUNCHER"/>
     </intent-filter>
</activity>
```


Adicone o serviço antes da Tag De Aplication.

```
<service android:name="uk.lgl.modmenu.FloatingModMenuService"
        android:enabled="true"
        android:exported="false"/>
```

   Seu resultado será algo como:<br>
![](https://i.imgur.com/rw0hawa.png)


Agora compile APK do jogo.

Isso irá iniciar a tela de login e depois o jogo.

![](https://i.imgur.com/h0ZAn00.gif)

# Proteção do APK

Para evitar os famosos "crackers" eu fiz um comando para que a lib seja carregada somente se o usuario for valido ou se ele estiver logando.
Entretanto se ele ficar muito tempo na tela e continuar errando os usuarios a tela ira fechar.

Não sei ainda se esse metodo pode ser burlado.

**Não venham no meu privado reclamando de Erros no AIDE, eu usei o Android Studio, mas se você consegue compilar pelo Aide entao seja feliz!**



