package com.example.java8.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("/Users/xjliu/Downloads");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
		   for(Path element: stream) {
//		      System.out.println(element.getFileName()+"\t"+Files.isDirectory(element));
		   }
		}
		
		
		Files.walk(Paths.get("/Users/xjliu/Downloads"), 5, FileVisitOption.FOLLOW_LINKS)
//		   .filter(p -> p.getFileName().endsWith("txt"))
		   .forEach(p -> System.out.println("Found file: "+p.toAbsolutePath()));
	}

}
