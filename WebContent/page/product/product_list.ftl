<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
	<link href="/style/manage/page.css" rel="stylesheet" />
	<script type="text/javascript" src="/script/product/product.js"></script>
	<title> 首页</title>
	
	<script type="text/javascript">
		$(function(){
		    $('.pagination').pagination(${search.totalRecords?c}, {
				items_per_page: ${search.pageSize},
				current_page: ${search.pageNo - 1},
				prev_show_always:false,
				next_show_always:false,
				link_to: encodeURI('/product/productInfo.go?pageNo=__id__')
		    });
	   	});
	</script>
	
</head>
  <body>
  
<div class="views">
    <!--头部导航-->
   <#include "/index/common/top.ftl">
    <div class="view noneBG" style="background: none;">
        <!--中间内容-->
        <div class="content clearfix ">
            <div class="content-block ">
                <img class="content-top-img box-shadow" src="/images/common/0020.jpg" />
            </div>
            <div class="content-content clearfix" >
                <div class="content-text" style="">
                    <h3 class="h3" style="">欢迎来到携手管理金融管理中心？</h3>
                    <div>
                        <p class="p2">
                            惠农时贷网是“惠农时贷资产管理有限公司”旗下专业现代化平台，<br>
                            平台联合北大“富民公社”进行农村金融创新，<br>
                        </p>
                    </div>
                </div>
                <div class="page1">
                    <div class="list clearfix">
                        <div class="table-menu clearfix">
                            <ul class="list-ul product_list product_index">
                                <#if fundTypes??>
					    			<#list fundTypes as fund>
					    				<#if fund.id = pid>
					    					<li class="aActive"><a href="/product/productInfo.go?pid=${fund.id}">${fund.fundName}</a></li>
					    					<#else>
					    					<li><a href="/product/productInfo.go?pid=${fund.id}">${fund.fundName}</a></li>
					    				</#if>
					    					
						      		</#list>
						      	</#if>
                            </ul>
							<br>
                            
                        </div>
                        <ul class="fL clear" style="margin: 15px 0 0 30px; display:none;">
                        	<li class="fL select-li">
                        		<a href="javascript:;">
	                        		<select>
	                        			<option>预期收益</option>
	                        			<option>1000</option>
	                        			<option>2000</option>
	                        			<option>3000</option>	
	                        		</select>
                        		</a>
                        	</li>
                        	<li class="fL select-li">
                        		<a href="javascript:;">
                        		<select>
                        			<option>投资额度</option>
	                        			<option>1000</option>
	                        			<option>2000</option>
	                        			<option>3000</option>	
	                        		</select>
                        		</a>
                    		</li>
                        	<li class="fL select-li">
                        		<a href="javascript:;">
		                        	<select>
		                				<option>投资期限</option>
		                    			<option>1000</option>
		                    			<option>2000</option>
		                    			<option>3000</option>	
		                    		</select>
                        		</a>
                        	</li>
                        </ul>
                    </div>
                </div>
                <div class="table-div" style="height:460px;">
                    <table class="tab  tabActive"><!-- 表格 -->
                        <tbody class="tbody product">
                        <tr class="table-title product-title"><!-- 表格行 -->
                            <th>借款标题</th>
                            <th>信用等级</th>
                            <th>利率</th>
                            <th>金额</th>
                            <th>期限</th>
                            <th>进度</th>
                            <th>操作</th>
                        </tr>
                        
                        <#if proInfos??>
			    			<#list proInfos as a>
		    					<tr class="product-list">
		                            <td><a href="/product/productInfo/detail.go?id=${a.id}">${a.productName?default("产品名称")}</a></td>
		                            <td><span class="span2 creditLevle" style="">${a.creditLevle?default("A")}</span></td>
		                            <td><span class="span3" style="" >${a.yearInterestRate?default("0")}%</span><span style="font-size: 10px;">每年</span></td>
		                            <td><span class="span4" style="" >${a.fundScale?default("0")}</span>元</td>
		                            <td><span class="span5" style="" >${a.investmentTimeLimit?default("0")}</span>个月</td>
		                            <td><span class="span6" style=""><#if a.totalMoney?? && a.totalMoney == 0>0<#else>${(a.totalMoney/a.fundScale*100)?int+1}</#if>%</span></td>
		                            <td>
		                            	<#if a.toExamineStatus == 1>等待审核</#if>
		                            	<#if a.toExamineStatus == 2>已审核</#if>
		                            	<#if a.toExamineStatus == 3>禁用</#if>
		                            </td>
		                        </tr>
				      		</#list>
				      	</#if>
					      	
                        </tbody>
                    </table>
                </div>
                <div class="paging clearfix">
                        <div class="pagination rightPager"></div>
                    </div>
                </div>
            </div>
        </div>
        <!--底部工具栏  content content-content content-block-->
        <div class="apply m-l clearfix">
            <div class="fL">
                <p class="apply-methods">
                    报名方式一：星辉财富贵宾服务热线 400-6099-800
                </p>
                <p class="apply-methods">
                    报名方式二：请扫描携手金融网二维码
                </p>
                <p class="apply-methods">
                    报名方式三：在线填写真实姓名和电话号码
                </p>
                <p class="p3">携手金融网工作人员在两个工作日内与您联系</p>
                <div class="">
                    <div class="VIP-phone clearfix">
                        <span class="input-title fL">贵宾姓名：</span>
                         <input class="page-input-text fl" id="vipName" type="text" >
                    </div>
                    <div class="VIP-phone clearfix">
                        <span class="input-title fL">联系电话：</span>
                        <input class="page-input-text fL" type="text" id="vipMobile">
                        <button class="submit" onclick="return addVipUser()">提 交</button>
                    </div>
                </div>
            </div>

            <div class="fL">
                <img class="Qr-code" src="/images/common/0019.jpg" />
            </div>
        </div>
		
    </div>
    <#include "/index/common/foot.ftl">
</div>

<script type="text/javascript" src="/resources/common/plugin/jquery/js.js"></script>

<script type="text/javascript">
	var array = new Array("A","B","C","D","E","F","G","H","I");//直接定义并初始化
	$('.creditLevle').each(function(){
		$(this).text(array[$(this).text()]);
	});

</script>

  </body>
</html>
