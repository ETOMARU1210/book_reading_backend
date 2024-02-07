# [読書管理アプリ(バックエンド)](https://github.com/ETOMARU1210/book_reading_backend.git)

私は本を読むこどがあるのだが、読み終わったときにどんな本を読んだのかどのくらい読んだのか、読んだ本の値段の合計などを知りたいと思ったことがあった。そのような管理できるアプリがあれば自分はこのぐらいの本を読んだのかを可視化できるため、モチベーションにつながり、達成感を味わえるのではないかと思って作った。

# デモ動画

- 読書管理アプリ.gif
- 読書管理アプリ.mp4

# 特徴

どの本をどのくらいの読み、どのくらいの値段分読んだのかを見ることができる。本を読むことでお金が増えている感覚を得られ、達成感を味わうので本を読むモチベーションを高める

# インストールするもの(Maven)

```bash
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.0</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.bezkoder</groupId>
	<artifactId>spring-boot-security-postgresql</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-boot-security-postgresql</name>
	<description>Spring Boot, Spring Security, PostgreSQL: JWT Authentication
		&amp; Authorization example</description>

	<properties>
		<java.version>17</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.5</version>
		</dependency>

		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>
```

# 実行方法

総合開発環境 Eclipse ダウンロード(Java)
git clone は eclipse で行う
pom.xml を右クリック → 実行 →Maven install からダウンロード

```bash
git clone https://github.com/ETOMARU1210/book_reading_frontend.git
EclipseのBootダッシュボードからlocalにあるbook_reading_backendを起動するかプロジェクトから実行
```

# 著者

- ETOMARU1210
- inori0218adt@gmail.com

# ライセンス

ライセンスを明示する

@ 2024 ETOMARU1210
