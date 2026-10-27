# Spck Creator + AI — Android APK

Веб-IDE для создания сайтов с ИИ-ассистентом, упакованная в Android-приложение (WebView).
Всё работает офлайн, кроме обращений к API выбранного ИИ-провайдера.

## Способ 1. GitHub Actions — без установки чего-либо (рекомендую)

1. Создайте репозиторий на github.com и загрузите туда **содержимое этой папки**
   (кнопка «Add file → Upload files», либо `git push`).
2. Откройте вкладку **Actions** → выберите workflow «Сборка APK» → **Run workflow**.
3. Через ~5–7 минут сборка закончится. Откройте её и внизу скачайте артефакт
   **SpckCreator-AI.apk** — это и есть готовое приложение.
4. Перекиньте APK на телефон, установите (разрешите «установку из неизвестных источников»).

## Способ 2. Android Studio (если уже установлена)

1. Android Studio → **Open** → выберите эту папку.
2. Дождитесь синхронизации Gradle.
3. **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
4. APK появится в `app/build/outputs/apk/debug/app-debug.apk`.

## Примечания

- Приложение подписано стандартным debug-ключом Android — для личного
  использования этого достаточно. Для публикации в Google Play нужен
  release-сборка со своим ключом (Build → Generate Signed Bundle/APK).
- INTERNET-разрешение нужно, чтобы WebView мог обращаться к API
  Gemini / Groq / OpenRouter и т.д. Провайдеры с CORS-ограничениями
  (OpenAI, Anthropic напрямую) могут не работать — используйте OpenRouter.
- Данные (API-ключ, проекты, чат) хранятся в localStorage WebView телефона.
