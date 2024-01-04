package practice.crawltest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

@SpringBootApplication
public class CrawltestApplication implements Serializable{

	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException {
		
		// 크롤링할 주소 설정  crawlingEnterUrl
		final String crawlingEnterUrl = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=105&sid2=228";
		Connection conn = Jsoup.connect(crawlingEnterUrl);

		Document document;
		// 저장할 파일 경로
		String filePath ="C:\\_work\\test_crawling\\crawltest\\crawltest\\result.txt";

		// 파일 저장하는 메소드 객체 생성
		FileOutputStream fileOutputStream = new FileOutputStream(filePath);

		try {
			document = conn.get();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			System.out.println("document result ");
			System.out.println("======================= ");

//			System.out.println(document.toString());
			
			// 파일 저장
			objectOutputStream.writeObject(document.toString());
			System.out.println("======================= ");
//			if(file.createNewFile()){
//				System.out.println("file create success");
//			}
//			else{ System.out.println("file create failed!"); }
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}




}
