package jtfl4processing.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public abstract class JTFLBasicAPI{

	public static String[] loadStrings(String filename) {
	    InputStream is = createInput(filename);
	    if (is != null) return loadStrings(is);
			return null;
	}
	
	private static String[] loadStrings(InputStream input) {
		try{
	        BufferedReader reader =
		    new BufferedReader(new InputStreamReader(input, "UTF-8"));
		      return loadStrings(reader);
		} catch (IOException e) {
		      e.printStackTrace();
		}
		return null;
	}
	  
	  private static InputStream createInput(String filename) {
		    InputStream input = createInputRaw(filename);
		    if ((input != null) && filename.toLowerCase().endsWith(".gz")) {
		      try {
		        return new GZIPInputStream(input);
		      } catch (IOException e) {
		        e.printStackTrace();
		        return null;
		      }
		    }
		    return input;
		  }

	  /**
	   * Call openStream() without automatic gzip decompression.
	   */
	  private static InputStream createInputRaw(String filename) {
	    InputStream stream = null;

	    if (filename == null) return null;

	    if (filename.length() == 0) {
	      // an error will be called by the parent function
	      //System.err.println("The filename passed to openStream() was empty.");
	      return null;
	    }

	    // safe to check for this as a url first. this will prevent online
	    // access logs from being spammed with GET /sketchfolder/http://blahblah
	    if (filename.contains(":")) {  // at least smells like URL
	      try {
	        URL url = new URL(filename);
	        stream = url.openStream();
	        return stream;

	      } catch (MalformedURLException mfue) {
	        // not a url, that's fine

	      } catch (FileNotFoundException fnfe) {
	        // Java 1.5 likes to throw this when URL not available. (fix for 0119)
	        // http://dev.processing.org/bugs/show_bug.cgi?id=403

	      } catch (IOException e) {
	        // changed for 0117, shouldn't be throwing exception
	        e.printStackTrace();
	        //System.err.println("Error downloading from URL " + filename);
	        return null;
	        //throw new RuntimeException("Error downloading from URL " + filename);
	      }
	    }
	    return null;
	  }
	  private static String[] loadStrings(BufferedReader reader) {
		    try {
		      String lines[] = new String[100];
		      int lineCount = 0;
		      String line = null;
		      while ((line = reader.readLine()) != null) {
		        if (lineCount == lines.length) {
		          String temp[] = new String[lineCount << 1];
		          System.arraycopy(lines, 0, temp, 0, lineCount);
		          lines = temp;
		        }
		        lines[lineCount++] = line;
		      }
		      reader.close();

		      if (lineCount == lines.length) {
		        return lines;
		      }

		      // resize array to appropriate amount for these lines
		      String output[] = new String[lineCount];
		      System.arraycopy(lines, 0, output, 0, lineCount);
		      return output;

		    } catch (IOException e) {
		      e.printStackTrace();
		      //throw new RuntimeException("Error inside loadStrings()");
		    }
		    return null;
		  }
}
