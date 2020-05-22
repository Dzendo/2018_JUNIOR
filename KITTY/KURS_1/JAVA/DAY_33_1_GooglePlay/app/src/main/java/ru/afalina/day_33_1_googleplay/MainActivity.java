package ru.afalina.day_33_1_googleplay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
// Как сделать простой список из массива, используя ListView
//Как загрузить текст из ресурсов
//Как загрузить html-текст в WebView
//Как передать данные из одной активности в другую

public class MainActivity extends AppCompatActivity {

    //Создаем массив разделов:
    private String titles[] = {
            "00. Начало",
            "01. Чем кормить кота.",
            "02. Как гладить кота.",
            "03. Как спит кот.",
            "04. Как играть с котом.",
            "05. Как разговаривать с котом",
            "06. Интересные факты из жизни котов.",
            "07. Как назвать кота.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Получим идентификатор ListView
        ListView listView = findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);

                intent.putExtra("title", position);
                Toast.makeText(getApplicationContext(),
                        "выбрал  "+position, Toast.LENGTH_LONG).show();

                //запускаем вторую активность
                startActivity(intent);
            }
        });
    }
}

/*
ERROR: Could not get unknown property 'config' for SigningConfig container of type org.gradle.api.internal.FactoryNamedDomainObjectContainer.
Open File
buildTypes{
release{
minifyEnabledfalse
proguardFilesgetDefaultProguardFile('proguard-android-optimize.txt'),'proguard-rules.pro'
signingConfigsigningConfigs.config    !!!!!!!
}
}
signingConfigs{
config{
storeFilefile('D:\\2018\\SCHOOL\\Afaline_key_store.jks')
storePasswordSystem.getenv('9037292652')
keyAlias='720'
keyPasswordSystem.getenv('9037200055')
}
}
ИХ НАДО ПОМЕНЯТЬ МЕСТАМИ:
 СНАЧАЛА signingConfigs а затем вызов
 signingConfigsigningConfigs.config тогда не ругается версия 3,3,13
 строит: debug если просто build/bundle
Выкладывает APK в app\build\outputs\apk\debug\app-debug.apk
Выкладывает Bundle в app\build\outputs\bundle\debug\app.aab

Если вызывать Build > Generate Singed то строит
 APK в      app\release\app-release.apk только если удалить старый
Bundle      app\release\app.aab только если удалить старый и при этом удаляет apk

Если переставиться на release в окошке BUILD Variаnts
То версия 3.3. 13 дает ошибку :
Keystore file 'D:\2018\SCHOOL\aaaaaaa_key_store.jks' not found for signing config 'release'.

ИТОГО можно ростроить руками через Generate Singed искать в app\release
В автомате не строит подписанную - ошибка ключа

Для автомата надо переписывать новый вид:
signingConfigs {
        config {
            storeFile file('D:\\2018\\SCHOOL\\aaaaaaa_key_store.jks')
            storePassword System.getenv('aaaaaaa')
            keyAlias = 'bbb'
            keyPassword System.getenv('bbbbbbb')
        }
    }
в старый вид:
   signingConfigs {
        config {
            keyAlias 'ccccccc'
            keyPassword 'ccccccc'
            storeFile file('D:/2018/SCHOOL/aaaaaaa.jks')
            storePassword 'aaaaaaa'
        }
    }
    Тогда все работает
    результат искать в :
\app\build\outputs\apk\release
\app\build\outputs\bundle\release
и похоже перед построением удалять предыдущую
 */
