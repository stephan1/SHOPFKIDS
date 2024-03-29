package com.oracle.shopforkids.utils;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

    // Properties
    // ---------------------------------------------------------------------------------

    private String imagePath; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.imagePath="/home/oracle/Webimgsource/images";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String requestedImage = request.getPathInfo();

	        // Check if file name is actually supplied to the request URI.
	        if (requestedImage == null) {
	            // Do your thing if the image is not supplied to the request URI.
	            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
	            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	            return;
	        }
	        
	     // Decode the file name (might contain spaces and on) and prepare file object.
	        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
	     // Check if file actually exists in filesystem.
	        if (!image.exists()) {
	            // Do your thing if the file appears to be non-existing.no
	            // Throw an exception, or send 404, or show default/warning image,
	            // or just ignore it.
	            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	            return;
	        }
	     // Get content type by filename.
	        String contentType = getServletContext().getMimeType(image.getName());
	        if (contentType == null || !contentType.startsWith("image")) {
	            // Do your thing if the file appears not being a real image.
	            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
	            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	            return;
	        }
	        
	     // Init servlet response.
	        response.reset();
	        response.setBufferSize(DEFAULT_BUFFER_SIZE);
	        response.setContentType(contentType);
	        response.setHeader("Content-Length", String.valueOf(image.length()));
	        response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + "\"");
	        // Prepare streams.
	        BufferedInputStream input = null;
	        BufferedOutputStream output = null;

	        try {
	            // Open streams.
	            input = new BufferedInputStream(new FileInputStream(image), DEFAULT_BUFFER_SIZE);
	            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

	            // Write file contents to response.
	            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	            int length;
	            while ((length = input.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }
	        } finally {
	            // Gently close streams.
	            close(output);
	            close(input);
	        }


	}

	private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
        }
}
}
