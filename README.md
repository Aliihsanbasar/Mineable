# Mineable

Coinlerin bilgilerini retrofit yardımıyla çekip ekran gösteren bir uygulamadır. Login işlemleri Google Firebase Authentication ile gerçekleştirilmektedir. Kullanılan kütüphanelere aşağıdan ulaşabilirsiniz.

Kullanılan kütüphaneler:
  //Firebase
  implementation platform('com.google.firebase:firebase-bom:30.1.0')
  implementation 'com.google.firebase:firebase-auth'

  //Retrofit
  implementation 'com.squareup.retrofit2:retrofit:2.5.0'
  implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
  implementation 'com.squareup.okhttp3:okhttp:3.13.1'
  implementation 'com.squareup.okhttp3:logging-interceptor:3.13.1'
  implementation 'com.google.code.gson:gson:2.8.6'

Uygulama içi ekran görüntüleri:

LoginActivity
![image](https://user-images.githubusercontent.com/39854594/173445394-7411bed7-e444-4671-95f2-c615bf21d5da.png)

ForgotPasswordActivity
![image](https://user-images.githubusercontent.com/39854594/173445544-ebde4cf9-b7d1-4b98-afa5-aa03c4c00976.png)

MainActivity
![image](https://user-images.githubusercontent.com/39854594/173445739-6a518c18-f55c-446a-a3cb-47d36af49c45.png)

