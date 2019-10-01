package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class OneToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();
		Transaction t = s.beginTransaction();
		Movie m = new Movie();
		m.setTitle("DDLJ");
		m.setReleaseDate(LocalDate.of(1999, 3, 12));
		
		Song s1 = new Song("Tujhe Dekha To Ye Jaana Sanam");
		Song s2 = new Song("Ho Gaya Hai Tujhko To Pyaar");
		Song s3 = new Song("Mere Khawabo Mein Jo Aye");
		s1.setMovie(m);
		s2.setMovie(m);
		s3.setMovie(m);
		
		List<Song> listOfSongs = new ArrayList<Song>();
		listOfSongs.add(s1);
		listOfSongs.add(s2);
		listOfSongs.add(s3);
		
		m.setSongs(listOfSongs);
		s.save(s1);
		s.save(s2);
		s.save(s3);
		s.save(m);
		t.commit();
		s.close();
		System.exit(0);
	}

}
