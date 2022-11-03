# java_spring_beginner.lesson.java

Springフレームワークについての学習用プロジェクト。  
がんばろ♪

## 自分用メモ

### @configuration

設定ファイルであることを示すアノテーション。

### @ControllerAdvice

メソッドの実行前の共通処理を指定する。  
空文字をnullに変換したりとか、、、  

### @SpringBootApplication

Springの設定を一括で。  

### リクエストスコープ

モデルが有効となるアクセスごとに生成されるスコープのこと。  
ViewがHTMLを生成する際に必要なデータを格納。 

### フラッシュスコープ

一度きりのセッション。  
リダイレクト後に一度だけ値を保持して表示する。  

## ディレクトリ構成

```dir
- src
  - main (Javaコード)
  - resources
    - templates (HTMLとか)
    - static (CSSとかJSとか)
    - application.yml (データベースの設定 | 自動で読み込まれる)
    - *.sql (データベース作成後に実行されるSQL)
- build.gradle (パッケージの設定とかイロイロ)
```

## 参考文献

- <https://www.udemy.com/share/101w4u3@9mcf2Gbl_hYNQop2w8_6B5L4fzDhgXeC0rmsOpWTN-TSnJXFqZ2YWhllyGoI0LBbKw==/>
