package com.xsjrw.websit.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsjrw.common.util.Pager;
import com.xsjrw.websit.domain.admin.ColumnGroup;
import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.dto.MasterDTO;
import com.xsjrw.websit.service.MasterService;
import com.xsjrw.websit.service.PublishService;

@Component
/**
 * @author Zhiwei Wang
 */
@RequestMapping("/admin/master")
public class MasterController {
	public static final String MASTER = "master";

	private static Logger logger = Logger.getLogger(MasterController.class);

	private MasterDTO masterDTO;
	private String actionNos;
	private Pager pager;
	private Integer page;
	private Integer pageSize = 15;
	private String groupColumnId;
	private String actionHtml;
	List<ColumnGroup> columnGroupList = new ArrayList<ColumnGroup>();
	private List<Master> masterList = new ArrayList<Master>();
	private String validateCode;
	private Integer masterMtid;
	
	@Resource private MasterService masterService;
	@Resource private PublishService publishService;

	/**
	 * 去登陆页面
	 * @return
	 */
	@RequestMapping(value = "login")
	public String goLogin() {
		return "manage/master/login";
	}
	
//	/**
//	 * 执行登陆请求
//	 * @return
//	 */
//	public String executeLogin(HttpServletRequest request) {
//		if(masterDTO != null){
//			String account = masterDTO.getAccount();
//			String password = masterDTO.getPassword();
//			Object validatec = request.getSession().getAttribute("sessionVerifyCode");
//			if(validatec != null && !StringUtils.isBlank(String.valueOf(validatec)) && !StringUtils.isBlank(validateCode)){
//				if(String.valueOf(validatec).equals(validateCode.toLowerCase())){
//					if(!StringUtils.isBlank(account)){
//						Master master = masterService.obtainMasterBuyAccount(account);
//						if(master != null){
//							String pass = master.getPassword();
//							if(password.trim().equals(pass.trim())){
//								if(master.getForbidden().shortValue() == 1){
//									masterDTO.setFlag("1006");//登陆失败，该账户已被禁用
//									return "login";
//								}
//								masterMtid = master.getMtId();
//								request.getSession().setAttribute(MasterController.MASTER, master);
//								StringBuffer sb = new StringBuffer();
//								Set<MasterMapAction> masterMapActionList = master.getMasterMapActionList();
//								Action action = null;
//								for(MasterMapAction masterMapAction : masterMapActionList){
//									action = masterMapAction.getAction();
//									sb.append(action.getActionNo()).append("|");
//								}
//								actionNos = sb.toString();
//								
//								Set<ColumnGroup> aColumnGroupList = new HashSet<ColumnGroup>();
//								Set<ActionColumn> aActionColumnList = new HashSet<ActionColumn>();
//								Set<Action> aActionList = new HashSet<Action>();
//								
//								columnGroupList = masterService.obtainAllColumnGroupList();
//								for(ColumnGroup columnGroup : columnGroupList){
//									boolean groupFlag = false;
//									for(ActionColumn  actionColumn : columnGroup.getActionColumnList()){
//										boolean actionFlag = false;
//										for(Action a : actionColumn.getActionList()){
//											if(actionNos.contains(a.getActionNo())){
//												aActionList.add(a);
//												actionFlag = true;
//												groupFlag = true;
//											}
//										}
//										if(actionFlag){
//											aActionColumnList.add(actionColumn);
//										}
//									}
//									if(groupFlag){
//										aColumnGroupList.add(columnGroup);
//									}
//								}
//								request.getSession().setAttribute("groupColumnId", "");
//								request.getSession().setAttribute("actionNos", actionNos);
////								logger.error("aColumnGroupList=" + aColumnGroupList);
//								if (null != aColumnGroupList) {
////									logger.error("aColumnGroupList.size=" + aColumnGroupList.size());
//								}
//								request.getSession().setAttribute("aColumnGroupList", aColumnGroupList);
//								request.getSession().setAttribute("aActionColumnList", aActionColumnList);
//								request.getSession().setAttribute("aActionList", aActionList);
//								masterDTO.setFlag("1005"); //登陆成功
//								return "success";
//							}else{
//								masterDTO.setFlag("1004");//登陆失败，密码不正确
//							}
//						}else{
//							masterDTO.setFlag("1003");//登陆失败，该用户不存在
//						}
//					}else{
//						masterDTO.setFlag("1002");//登陆失败，登录名不能为空
//					}
//				}else{
//					masterDTO.setFlag("1008");//登陆失败，验证码不正确
//					return "login";
//				}
//			}else{
//				masterDTO.setFlag("1007");//登陆失败，验证码不能为空
//				return "login";
//			}
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1001");//登陆失败，登录名和密码不能为空
//		}
//		
//		return "login";
//	}
//
//	/**
//	 * 去添加管理员页面
//	 * @return
//	 */
//	public String goMasterAdd(HttpServletRequest request) {
//		return "master_add";
//	}
//	
//	/**
//	 * 执行管理员添加操作
//	 * @return
//	 */
//	public String goExecuteMasterAdd(HttpServletRequest request) {
//		if(masterDTO != null){
//			Master master = new Master();
//			String account = masterDTO.getAccount();
//			
//			if(!StringUtils.isBlank(account)){
//				master = masterService.obtainMasterBuyAccount(account);
//				if(master != null){
//					masterDTO.setFlag("1004");//添加失败，该账号已存在
//				}else{
//					master = masterService.saveMaster(masterDTO);
//					masterDTO.setFlag("1003");//保存成功。
//				}
//			}else{
//				masterDTO.setFlag("1002");//保存失败，账号不能为空
//			}
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1001");//保存失败，保存信息为空
//		}
//		return "master_add";
//	}
//	
//	/**
//	 * 执行管理员添加操作
//	 * @return
//	 */
//	public String obtainAllMasterList(HttpServletRequest request) {
//		if(page == null){
//			page = 1;
//		}
//		pager = masterService.obtainMasterList(masterDTO, page, pageSize);
//		
//		return "master_list";
//	}
//	
//	/**
//	 * 去更新管理员页面
//	 * @return
//	 */
//	public String goUpdateMaster(HttpServletRequest request) {
//		if(masterDTO != null){
//			if(masterDTO.getId() != null){
//				Master master = null;
//				master = masterService.obtainMasterBuyId(masterDTO.getId());
//				if(master != null){
//					masterDTO.setAccount(master.getAccount());
//					masterDTO.setPassword(master.getPassword());
//					masterDTO.setEmail(master.getEmail());
//					masterDTO.setForbidden(master.getForbidden());
//					masterDTO.setMobile(master.getMobile());
//					masterDTO.setName(master.getName());
//					masterDTO.setPosition(master.getPosition());
//					masterDTO.setTelephone(master.getTelephone());
//				}
//			}
//		}
//		return "master_update";
//	}
//	
//	/**
//	 * 执行更新管理员页面
//	 * @return
//	 */
//	public String executeUpdateMaster(HttpServletRequest request) {
//		if(masterDTO != null){
//			if(masterDTO.getId() != null){
//				Master master = null;
//				master = masterService.updateMaster(masterDTO);
//				if(master != null){
//					masterDTO.setFlag("1001");//更新成功
//				}else{
//					masterDTO.setFlag("1004");//更新失败，没有像匹配对象
//				}
//			}else{
//				masterDTO.setFlag("1003");//更新失败，传输对象为空
//			}
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1002");//更新失败，传输对象为空
//		}
//		return "master_update";
//	}
//	
//	/**
//	 * 到达更新权限页面
//	 * @return
//	 */
//	public String goUpdateAction(HttpServletRequest request) {
//		if(masterDTO != null){
//			if(masterDTO.getId() != null){
//				Master master = masterService.obtainMasterBuyId(masterDTO.getId());
//				columnGroupList = masterService.obtainAllColumnGroupList();
//				if(master != null){
//					StringBuffer sb = new StringBuffer();
//					Set<MasterMapAction> masterMapActionList = master.getMasterMapActionList();
//					Action action = null;
//					for(MasterMapAction masterMapAction : masterMapActionList){
//						action = masterMapAction.getAction();
//						sb.append(action.getActionNo()).append("|");
//					}
//					actionNos = sb.toString();
//				}
//			}else{
//				masterDTO.setFlag("1002");//更新失败，未查询到相关管理员
//			}
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1001");//更新失败，没有响应管理员
//		}
//		
//		return "master_action_update";
//	}
//	
//	/**
//	 * 执行更新权限操作
//	 * @return
//	 */
//	public String executeUpdateAction(HttpServletRequest request) {
//		if(masterDTO != null){
//			if(masterDTO.getId() != null){
//				Master master = masterService.obtainMasterBuyId(masterDTO.getId());
//				if(master != null){
//					StringBuffer sb = new StringBuffer();
//					Set<MasterMapAction> masterMapActionList = master.getMasterMapActionList();
//					String actionNames = request.getParameter("actionNames");
//					String[] actionIds = null;
//					if(!StringUtils.isBlank(actionNames)){
//						actionIds = actionNames.split(",");
//					}
//					Action action = null;
//					
//					MasterMapAction masterMapAction = null;
//					Set<MasterMapAction> newMasterMapActionList = new HashSet<MasterMapAction>();
//					if(actionIds != null){
//						for(String id : actionIds){
//							action = masterService.obtainActionBuyId(Integer.parseInt(id));
//							if(action != null){
//								masterMapAction = new MasterMapAction();
//								masterMapAction.setAction(action);
//								masterMapAction.setMaster(master);
//								newMasterMapActionList.add(masterMapAction);
//							}
//						}
//					}
//					master.setMasterMapActionList(newMasterMapActionList);
//					masterService.deleteMasterActions(master);
//					masterService.updateMaster(master);
//					masterDTO.setFlag("1003");//权限更新成功
//				}
//			}else{
//				masterDTO.setFlag("1002");//更新失败，未查询到相关管理员
//			}
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1001");//更新失败，没有响应管理员
//		}
//		
//		return "master_action_update_success";
//	}
//	
//	/**
//	 * 获取大栏目下子权限
//	 * @return
//	 */
//	public String obtainActionByColumnGroupId(HttpServletRequest request) {
//		if(masterDTO != null && masterDTO.getGroupColumnId() != null){
//			Set<ColumnGroup> aColumnGroupList = new HashSet<ColumnGroup>();
//			Set<ActionColumn> aActionColumnList = new HashSet<ActionColumn>();
//			Set<Action> aActionList = new HashSet<Action>();
//			aColumnGroupList = (Set<ColumnGroup>)request.getSession().getAttribute("aColumnGroupList");
//			aActionColumnList = (Set<ActionColumn>)request.getSession().getAttribute("aActionColumnList");
//			aActionList = (Set<Action>)request.getSession().getAttribute("aActionList");
////			logger.error("aColumnGroupList=" + aColumnGroupList);
////			if (null != aColumnGroupList) {
////				logger.error("aColumnGroupList.size=" + aColumnGroupList.size());
////			}
//			request.getSession().setAttribute("groupColumnId", masterDTO.getGroupColumnId());
//			StringBuffer html = new StringBuffer();
//			columnGroupList = masterService.obtainAllColumnGroupList();
//			for(int i=0; i < columnGroupList.size(); i++){
//				ColumnGroup columnGroup = columnGroupList.get(i);
//				if((int)(columnGroup.getCgId()) == (int)(masterDTO.getGroupColumnId())){
//					Set<ActionColumn> actionColumnList = columnGroup.getActionColumnList();
//					for(ActionColumn actionColumn : actionColumnList){
//						Set<Action> actionList = actionColumn.getActionList();
////						logger.error("actionList.size() = " + actionList.size() + "; actionColumn.getName= " + actionColumn.getName());
//						boolean actionColumnFlag=false;
//						for(ActionColumn aActionColumn : aActionColumnList){
//							if((int)(actionColumn.getAcId()) == (int)(aActionColumn.getAcId())){
//								actionColumnFlag = true;
//								break;
//							}
//						}
//						if(actionColumnFlag){
//							html.append("<div class='dt'>"+actionColumn.getName()+"</div>");
//							for(Action action : actionList){
//								boolean actionFlag=false;
//								html.append("<ul id='ul0'>");
//								for(Action aAction : aActionList){
//									try {
//										if((int)(action.getAtId()) == (int)(aAction.getAtId()) && (aAction.getViewmode()==null?1:aAction.getViewmode()) == 1){
//											html.append("<li class='dd' ><a href=\""+aAction.getActionPath()+"\">"+aAction.getName()+"</a></li>");
//										}
//									} catch (Exception e) {
//										logger.error(action + "; " + aAction, e);
//										if (null != aAction) {
//											logger.error(
//												+ aAction.getAtId()
//												+ "; aAction.getName= "
//												+ aAction.getName()
//												+ "; aAction.getViewmode= " + aAction.getViewmode(), e);
//										}
//										if (null != action) {
//											logger.error(
//													"; action.getName= "
//													+ action.getName());
//										}
//									}
//								}
//								html.append("</ul>");
//							}
//						}
//					}
//				}
//			}
//			actionHtml = html.toString();
//			masterDTO.setFlag("1002");//获取成功
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1001");//获取失败
//		}
//		
//		return "obtain_action_list";
//	}
//	
//	/**
//	 * 到达复制权限页面
//	 * @return
//	 */
//	public String goCopyAction(HttpServletRequest request) {
//		if(masterDTO != null){
//			if(masterDTO.getId() != null){
//				Master master = masterService.obtainMasterBuyId(masterDTO.getId());
//				columnGroupList = masterService.obtainAllColumnGroupList();
//				masterList = masterService.obtainAllMasterList();
//				if(master != null){
//					StringBuffer sb = new StringBuffer();
//					Set<MasterMapAction> masterMapActionList = master.getMasterMapActionList();
//					Action action = null;
//					for(MasterMapAction masterMapAction : masterMapActionList){
//						action = masterMapAction.getAction();
//						sb.append(action.getActionNo()).append("|");
//					}
//					actionNos = sb.toString();
//				}
//			}else{
//				masterDTO.setFlag("1002");//更新失败，未查询到相关管理员
//			}
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1001");//更新失败，没有响应管理员
//		}
//		
//		return "master_action_copy";
//	}
//	
//	/**
//	 * 执行Copy权限操作
//	 * @return
//	 */
//	public String executeCopyAction(HttpServletRequest request) {
//		if(masterDTO != null){
//			if(masterDTO.getId() != null){
//				Master master = masterService.obtainMasterBuyId(masterDTO.getId());
//				if(master != null){
//					StringBuffer sb = new StringBuffer();
//					Set<MasterMapAction> masterMapActionList = master.getMasterMapActionList();
//					String actionNames = request.getParameter("actionNames");
//					String[] actionIds = null;
//					if(!StringUtils.isBlank(actionNames)){
//						actionIds = actionNames.split(",");
//					}
//					Action action = null;
//					
//					MasterMapAction masterMapAction = null;
//					Set<MasterMapAction> newMasterMapActionList = new HashSet<MasterMapAction>();
//					if(actionIds != null){
//						for(String id : actionIds){
//							action = masterService.obtainActionBuyId(Integer.parseInt(id));
//							if(action != null){
//								masterMapAction = new MasterMapAction();
//								masterMapAction.setAction(action);
//								masterMapAction.setMaster(master);
//								newMasterMapActionList.add(masterMapAction);
//							}
//						}
//					}
//					master.setMasterMapActionList(newMasterMapActionList);
//					masterService.deleteMasterActions(master);
//					masterService.updateMaster(master);
//					masterDTO.setFlag("1003");//拷贝成功
//				}
//			}else{
//				masterDTO.setFlag("1002");//拷贝失败，未查询到相关管理员
//			}
//		}else{
//			masterDTO = new MasterDTO();
//			masterDTO.setFlag("1001");//拷贝失败，没有响应管理员
//		}
//		
//		return "master_action_copy_success";
//	}
//	public String loginOut(HttpServletRequest request){
//		request.getSession().removeAttribute(MasterController.MASTER);
//		request.getSession().removeAttribute("groupColumnId");
//		request.getSession().removeAttribute("acolumnGroupList");
//		request.getSession().removeAttribute("aActionColumnList");
//		request.getSession().removeAttribute("aActionList");
//		return "login";
//	}
//	
	public MasterDTO getMasterDTO() {
		return masterDTO;
	}

	public void setMasterDTO(MasterDTO masterDTO) {
		this.masterDTO = masterDTO;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getActionNos() {
		return actionNos;
	}

	public void setActionNos(String actionNos) {
		this.actionNos = actionNos;
	}

	public List<ColumnGroup> getColumnGroupList() {
		return columnGroupList;
	}

	public void setColumnGroupList(List<ColumnGroup> columnGroupList) {
		this.columnGroupList = columnGroupList;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getGroupColumnId() {
		return groupColumnId;
	}

	public void setGroupColumnId(String groupColumnId) {
		this.groupColumnId = groupColumnId;
	}

	public String getActionHtml() {
		return actionHtml;
	}

	public void setActionHtml(String actionHtml) {
		this.actionHtml = actionHtml;
	}

	public List<Master> getMasterList() {
		return masterList;
	}

	public void setMasterList(List<Master> masterList) {
		this.masterList = masterList;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public Integer getMasterMtid() {
		return masterMtid;
	}

	public void setMasterMtid(Integer masterMtid) {
		this.masterMtid = masterMtid;
	}
}
