package com.hotelRecommendation.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotelRecommendation.bean.HotelBean;
import com.hotelRecommendation.bean.HotelImageBean;
import com.hotelRecommendation.bean.RoomImageBean;
import com.hotelRecommendation.database.DataBaseConnection;
import com.hotelRecommendation.database.HotelImageHelper;
import com.hotelRecommendation.database.HotelRoomImage;

/**
 * Servlet implementation class AddHotelRoomImage
 */
@WebServlet("/AddHotelRoomImage")
public class AddHotelRoomImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHotelRoomImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBaseConnection dbconnection=new DataBaseConnection();
        OutputStream out = response.getOutputStream();
        response.setContentType("image/png");
     
        
       
        try
        {

            Connection con=(Connection) dbconnection.connect();
            ResultSet rs=null;
            InputStream in = null;
      
            
            
            int  id = Integer.parseInt(request.getParameter("id"));       
               
            

            System.out.println("hotel_room_id ="+id);
            PreparedStatement display_img=(PreparedStatement)con.prepareStatement("SELECT hotel_room_image from hotel_room_image_tbl where hotel_room_id="+id+"");
            rs=(ResultSet)display_img.executeQuery();

            if(rs.next())
            {
                    in =rs.getBinaryStream(1);
                    byte b[]=new byte[in.available()];
                    System.out.println("total bytes : "+in.available());
                    int index = 0;
                    while((index=in.read(b))!=-1)
                    {
                            out.write(b,0,index);
                    }
            }

            in.close();
            out.close();
            System.out.println("Images Retrieved Successfully.....");

        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		PrintWriter out = response.getWriter();
        System.out.println("here");
        String contentType = request.getContentType();
        System.out.println("Content type is :: " + contentType);
        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
            DataInputStream in = new DataInputStream(request.getInputStream());
            int formDataLength = request.getContentLength();

            byte dataBytes[] = new byte[formDataLength];
            int byteRead = 0;
            int totalBytesRead = 0;
            while (totalBytesRead < formDataLength) {
                byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                totalBytesRead += byteRead;
            }

            String file = new String(dataBytes);
            String saveFile = file.substring(file.indexOf("filename=\"") + 10);
            //out.print("FileName:" + saveFile.toString());
            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
            //out.print("FileName:" + saveFile.toString());
            saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
            //out.print("FileName:" + saveFile.toString());

            //out.print(dataBytes);

            int lastIndex = contentType.lastIndexOf("=");
            String boundary = contentType.substring(lastIndex + 1, contentType.length());
            //out.println(boundary);
            int pos;
            pos = file.indexOf("filename=\"");

            pos = file.indexOf("\n", pos) + 1;

            pos = file.indexOf("\n", pos) + 1;

            pos = file.indexOf("\n", pos) + 1;


            int boundaryLocation = file.indexOf(boundary, pos) - 4;
            int startPos = ((file.substring(0, pos)).getBytes()).length;
            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
            String filename = saveFile;
            //saveFile = "C:\\Program Files\\Apache Software Foundation\\Tomcat 5.5\\webapps\\ROOT\\Extrusions\\" + saveFile;
            saveFile = "D:\\" + saveFile;
            //saveFile = "F:\\Movies\\" + saveFile;
            FileOutputStream fileOut = new FileOutputStream(saveFile);
            fileOut.write(dataBytes, startPos, (endPos - startPos));
            fileOut.flush();
            fileOut.close();

      //      HttpSession username = request.getSession(true);
      //      username.setAttribute("filename", saveFile);
            
            FileInputStream FIS = null;
            File img = new File(saveFile);
            FIS = new FileInputStream(img);
            
            
            
            HotelRoomImage roomImageHelper1=new HotelRoomImage();
            
            int hotelRoomid=roomImageHelper1.GetMaxid();
            
           RoomImageBean imageBean=new RoomImageBean();
           imageBean.setHotelRoomId(hotelRoomid);
           imageBean.setRoomImage(FIS);
            
          
           
           
           
        HotelRoomImage roomImageHelper=new HotelRoomImage();
          
        int result=  roomImageHelper.AddHotelRoomImage(imageBean);
        
        if(result==1)
        {
        	response.sendRedirect("viewHotelRoom.jsp");
        }
        else
        {
        	response.sendRedirect("error.jsp");
        }
            
        }
        
        
}

}


