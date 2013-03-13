/*
* ##library.name##
* ##library.sentence##
* ##library.url##
*
* Copyright ##copyright## ##author.name##
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
* 
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General
* Public License along with this library; if not, write to the
* Free Software Foundation, Inc., 59 Temple Place, Suite 330,
* Boston, MA  02111-1307  USA
* 
* @author      ##author.name##
* @modified    ##date##
* @version     ##library.prettyVersion## (##library.version##)
* 
* 
* The methods on this class are taken and modified from PApplet.java
* from the Processing core.  
* 
* 
*/

package jtfl4processing.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * Contains utility methods used by the JTFL implementations.
 * Eg. the methods to call the APIs.
 * @author tenko
 *
 */
public abstract class JTFLBase{

	
	/**
	 * The method to retrieve the response from the TFL APIs.
	 * Amended from Processing PApplet.java 
	 * @param url  TFL API url 
	 * @return returns an array of String containing the response, one line per element.
	 */
	public static String[] loadStrings(String url) {
	    InputStream is = createInput(url);
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
	      } catch (IOException e) {
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
