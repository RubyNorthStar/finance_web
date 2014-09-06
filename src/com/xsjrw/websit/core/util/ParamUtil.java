package com.xsjrw.websit.core.util;

import org.apache.commons.lang.StringUtils;

public class ParamUtil {
	
		/**
	 * 课程下的问题，发布问题图片地址(相对地址)
	 */
	public static String questionImageRelativelyPath; // resources/upload/question/img/
	
	/**
	 * 图片服务器绝对地址
	 */
	public static String imageServiceRealPath;//  D:/ProgramFiles/Tomcat 6.0/webapps/mars/
	
	/**
	 * 图片服务器绝对地址
	 */
	public static String imageServicePath;//  http://localhost:8080/mars/
	
	/**
	 * 默认头像地址
	 */
	public static String defaultUserPic;
	
	/**
	 * 默认男头像地址
	 */
	public static String defaultUserPicMan;
	
	/**
	 * 默认女头像地址
	 */
	public static String defaultUserPicWomen;
	
	/**
	 * 默认大头像地址
	 */
	public static String defaultUserPicMax;
	
	/**
	 * 默认大男头像地址
	 */
	public static String defaultUserPicManMax;
	
	/**
	 * 默认大女头像地址
	 */
	public static String defaultUserPicWomenMax;
	
	/**
	 * 经过剪切的图片地址
	 */
	public static String saveloadUrl; //     "http://it.sunland.org.cn/static-mars/headpic/"
	/**
	 * swf文件转换生成目录
	 */
	public static String swfSavePath; // D:/apache-tomcat-6.0.36/webapps/mars/upload/course/swf/
	/**
	 * swf显示url
	 */
	public static String swfShowPath;// http://localhost:8080/mars/resources/upload/course/swf/
	
	public static String videoPicturePath;
	/**
	 * 原图上传地址
	 */
	public static String userHeadPicturePath;
	
	public static String courseCoverPicturePath;
	public static String pdfUploadTemp;
	public static String hostUrl;
	//yy直播图片
	public static String yyOnlinePicturePath;
	//YY直播剪切前的图片
	public static String yyOnlinePicturePathTemp;
    //live直播图片
    public static String livePicturePath;
    //live直播剪切前的图片
    public static String livePicturePathTemp;
	//swftools linux路径
	public static String swfToolsLinuxPath;
	
	//用户小组
	public static String userGroupPath;
	//题库的图片路径
	public static String queQuestionPicturePath;
	
	//题库的图片路径
	public static String pptPath;
	//flash 直播路径
	public static String liveSwfPath;
	
	//北京互创时代短信 账号
	public static String UserId;
	//北京互创时代短信 密码
	public static String Password;
	//北京互创时代短信 业务代码
	public static int BizType;
	//头像尺寸30相数
	public static String userHeadPicturePathMin;
	//头像尺寸60相数
	public static String userHeadPicturePathMid;
	
	// context根路径
	public static String contextPath;
	
	//用户头像
	public static String queUserPic;
	
	//静态资源
	public static String staticSource;
	
	public static String queUserPicZoom;
	public static String queUserPicBig;
	
	public static String queUserPicMid;
	
	public static String queUserPicSmall;
	
	public static String memcacheServerUrl;
	/**
	 * 
	* @Title: getDefaultUserPic 
	* @Description: TODO(获取默认头像) 
	* @param sex
	* @return
	* @return String    返回类型 
	* @throws 
	* @exception 
	* @date 2013-12-17 下午12:05:16
	* @user by shangde
	 */
	public static String getDefaultUserPic(String sex){
		String defaultPic = contextPath + defaultUserPic;
		if(StringUtils.isNotBlank(sex)){
			if(sex.equals("男")){
				defaultPic = contextPath + defaultUserPicMan;
			}else if(sex.equals("女")){
				defaultPic = contextPath + defaultUserPicWomen;
			}
		}
		return defaultPic;
	}
	
	/**
	 * 
	* @Title: getDefaultUserPicMax 
	* @Description: TODO(获取默认大头像) 
	* @param sex
	* @return
	* @return String    返回类型 
	* @throws 
	* @exception 
	* @date 2013-12-17 下午12:05:16
	* @user by shangde
	 */
	public static String getDefaultUserPicMax(String sex){
		String defaultPic = contextPath + defaultUserPicMax;
		if(StringUtils.isNotBlank(sex)){
			if(sex.equals("男")){
				defaultPic = contextPath + defaultUserPicManMax;
			}else if(sex.equals("女")){
				defaultPic = contextPath + defaultUserPicWomenMax;
			}
		}
		return defaultPic;
	}
	
}
