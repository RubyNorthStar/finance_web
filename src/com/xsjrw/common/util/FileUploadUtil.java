package com.xsjrw.common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * 描述：文件上传工具类
 * 
 * @author yzp
 *
 */
public class FileUploadUtil {
	
	/**
	 * 
	 * 描述：图片 上传
	 *
	 * @param request HttpServletRequest 用于获取网站路径
	 * @param multipartRequest Spring 的multipartRequest
	 * @param modelName 模块名，附件的存储路径，为空时存储在网站根目录下的upload文件夹下，否则存储在upload下的model名下
	 * @param path 上传图片的路径地址
	 * @return 文件bean list，包含文件的服务端与客户端的名称
	 */
	public static List<FileBean> upload(HttpServletRequest request, MultipartRequest multipartRequest, String modelName,
			String path, String nextLevelPath){
		// 上传的文件列表
		List<FileBean> fileList = new ArrayList<FileBean>();
	
		StringBuilder uploadPath = new StringBuilder(path);
		uploadPath.append("/"+nextLevelPath+"/");
		
		File file = new File(uploadPath.toString());
		file.mkdirs();
		
		// 上传文件
		Iterator<String> iterator = multipartRequest.getFileNames();
		while(iterator.hasNext()){
			MultipartFile multipartFile = multipartRequest
					.getFile((String) iterator.next());
			if (multipartFile.isEmpty()) {
				continue;
			}
			// 构建FileBean
			FileBean fileBean = new FileBean();
			String originalFileName = multipartFile.getOriginalFilename();
			fileBean.setClientName(originalFileName);
			fileBean.setTagName(multipartFile.getName());
			fileBean.setAssociateEntity(modelName);
			fileBean.setUploadTime(StringUtil.getCurrentTimestamp());
			fileBean.setUUid(StringUtil.UUid());
			// 计算扩展名
			int lastIndexOfPoint = originalFileName.lastIndexOf(".");
			String fileExt = lastIndexOfPoint != -1 ? originalFileName
					.substring(originalFileName.lastIndexOf(".")) : "";
			//　serverName格式：modelName_时间戳.扩展名
					fileExt=fileExt.toLowerCase();
			StringBuilder serverName = new StringBuilder();
			// modelName为空时，serverName拼接upload_
			/*if(!Strings.isNullOrEmpty(modelName)){
				serverName.append(modelName).append("_");
			} else {
				serverName.append("upload").append("_");
			}*/
			serverName.append(Calendar.getInstance().getTimeInMillis());
			serverName.append(StringUtil.randomCharacter(10));
			serverName.append(fileExt);
			fileBean.setServerName(serverName.toString());

			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				inputStream = multipartFile.getInputStream();
				File temp = new File(uploadPath + serverName.toString());
				Image img = ImageIO.read(inputStream);
                // 判断图片格式是否正确
                if (img.getWidth(null) == -1) {
                        System.out.println(" can't read,retry!" + "<BR>");
                } else {
                        int newWidth; int newHeight;
                        // 判断是否是等比缩放
                        //if (this.proportion == true) {
                                // 为等比缩放计算输出的图片宽度及高度
//                                double rate1 = ((double) img.getWidth(null)) / (double) 680 ;
//                                double rate2 = ((double) img.getHeight(null)) / (double) 680 ;
                                
//                                System.out.println(img.getWidth(null));
//                                System.out.println(img.getHeight(null));
                                // 根据缩放比率大的进行缩放控制
//                                double rate = rate1 > rate2 ? rate1 : rate2;
//                                newWidth = (int) (((double) img.getWidth(null)) / rate1);
//                                newHeight = (int) (((double) img.getHeight(null)) / rate1);
                        //} else {
                               newWidth = img.getWidth(null); // 输出的图片宽度
                               newHeight = img.getHeight(null); // 输出的图片高度
//                        }
                        BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);

                        /*
                        * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的
                        * 优先级比速度高 生成的图片质量比较好 但速度慢
                        */
                        tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
                       // FileOutputStream out = new FileOutputStream(temp);
                        // JPEGImageEncoder可适用于其他图片类型的转换
                        outputStream = new FileOutputStream(temp);
                        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
                        encoder.encode(tag);
                 }
				
				byte[] buffer = multipartFile.getBytes();
				int byteread = 0;
				while ((byteread = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, byteread);
					outputStream.flush();
				}
				DecimalFormat df = new DecimalFormat("########0.00");
				fileBean.setFileSize(df.format(((double)temp.length())/1024));
				// 加入到list中
				fileList.add(fileBean);
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					if (outputStream != null) {
						outputStream.close();
					}
					if(inputStream != null ) {
						inputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileList;
	}
	
	
	/**
	 * 获取网站的绝对地址
	 * @param request HttpServletRequest
	 * @return 网站的绝对地址
	 */
	public static String getSitePath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}

}
