<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String jsUrl = request.getContextPath() + "/public/js/";
	String cssUrl = request.getContextPath() + "/public/css/";
	String imgUrl = request.getContextPath() + "/public/img/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>EStore百货铺子--只卖正品，顺丰包邮</title>
<link rel="icon" href="./public/img/title_icon.ico" type="image/x-icon"/>
<script type="text/javascript" src="<%=jsUrl%>jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=jsUrl%>jqPaginator.js"></script>
<script type="text/javascript" src="<%=jsUrl%>bootstrap.min.js"></script>
<script type="text/javascript" src="<%=jsUrl%>swiper.min.js"></script>

<link href="<%=cssUrl%>bootstrap.min.css" rel="stylesheet">
<link href="<%=cssUrl%>index.css" rel="stylesheet">
<link href="<%=cssUrl%>swiper.min.css" rel="stylesheet">
<style type="text/css">
ul li {
	list-style-type: none;
}

.tabswiper {
	margin-top: -85px;
	width: 100%;
	height: 480px;
	background-image: url("./public/img/tabimg1.jpg");
	position: relative;
	background-repeat: no-repeat;
	background-position: center top;
}

.focus-banner {
	padding-top: 30px;
	padding-bottom: 20px;
	position: relative;
	height: 392px;
	margin-bottom: 10px;
}

.swiper-container {
	margin-top: 25px;
	width: 1106px;
	height: 380px;
}

.anserdh {
cursor:pointer;
	border-radius: 5px;
	margin: 0;
	padding: 0;
	text-align: center;
	list-style-type: none;
}

.botborder, .topborder {
	height: 50px;
	background-color: #777777;
	color: #fff;
	line-height: 50px;
	font-size: 17px;
	letter-spacing: 2px;
}

.botborder {
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
}

.topborder {
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.add {
	cursor:pointer;
	letter-spacing: 2px;
	background-color: #777;
	color: #fff;
	line-height: 50px;
	font-size: 16px;
}

.addselect {
	letter-spacing: 2px;
	background-color: #F8F8F8;
	color: #777777;
	line-height: 50px;
	font-size: 18px;
}

.secondmenu {
	position: absolute;
	background: #F8F8F8;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	width: 990px;
	left: 130px;
	height: 495px;
	z-index: 10;
	top: 0;
	left: 100%;
	display: none;
	transition: all 0.1s linear;
}

.anserdh:hover+.secondmenu {
	display: block;
}

.menu-img {
	float: right;
	height: 495px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

.menu-type {
	cursor:pointer;
	align-items: center;
	margin: 20px 0px 20px 30px;
	float: left;
	width: 70%;
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
}

.secondmenu:hover {
	display: block;
}

.menu-detail-content {
	width: 75%;
	line-height: 25px;
	margin-left: 50px;
	font-size: 17px;
	letter-spacing: 2px;
}

.icon {
	width: 120px;
	height: 45px;
	text-align: center;
	font-size: 16px;
	letter-spacing: 3px;
	border: 1px solid #777777;
	position: relative;
	border-radius: 3px;
	background: #777777;
	color: #2F88EE;
	line-height: 45px;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	box-shadow: 1px 1px 7px #999;
	z-index: 10;
	/* min-width:0 */
}

.text_c {
	margin-left: 10px;
	color: #fff;
}

.icon:before {
	content: "";
	position: absolute;
	right: -17px;
	top: 6px;
	width: 32px;
	height: 31px;
	background: #777777;
	border-bottom: 1px solid #777777;
	border-left: 1px solid #777777;
	transform: rotate(225deg);
}

</style>
</head>
<body>
	<%@ include file="/commons/header.jsp"%>
	<div class="container tips">
		<c:if test="${param.model != null}">

			<div class="alert alert-success tip-success">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>成功！</strong>您已经将 <b>${param.brand } ${param.model} </b>加入到购物车中!
				<b><a
					href="computerServlet?method=forwardPage&page=cart&pageNo=${computerpage.pageNo }">立即查看购物车</a></b>
			</div>

		</c:if>
	</div> 
	<div class="tabswiper">
		<div class="focus-banner">
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<img class="swiper-slide" src="./public/img/swiper1.jpg"> <img
						class="swiper-slide" src="./public/img/swiper2.jpg"> <img
						class="swiper-slide" src="./public/img/swiper3.jpg"> <img
						class="swiper-slide" src="./public/img/swiper4.jpg">
				</div>
				<!-- 如果需要滚动条 -->
				<div class="swiper-scrollbar"></div>
			</div>
		</div>
	</div>
	<div class="container" style="display: flex; flex-direction: row;">
		<div style="width: 12%; position: relative;margin-top:55px">
			<ul class="anserdh" id="6">
				<li class="topborder" id="0">商品分类</li>
				<c:forEach items="${sessionScope.menutype}" var="mtype">
					<li class="add" id="menu${mtype.m_id}">${mtype.m_name}</li>
				</c:forEach>
				<li class="botborder"></li>
			</ul>
			<div class="secondmenu"></div>
		</div>
		<div style="width: 88%; display: flex; flex-direction: column;">
			<div class="container searchBox" >
				<div class="form-inline">
					<div class="form-group">
						<div >
						    <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
						    <div class="input-group">
						      <div class="input-group-addon">从</div>
						      <input type="text" class="form-control col-xs-1" id="minPrice" placeholder="最低价格"/>
						      <div class="input-group-addon">到</div>
						      <input type="text" class="form-control col-xs-1" id="maxPrice" placeholder="最高价格"/>
						    </div>
						  </div>
					 </div>
  					<button type="submit" class="btn btn-primary searchBtn " onclick="searchPrice()"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 查询</button>
				</div>
			</div>
			<div id="commodity">
			<!-- 商品显示区域 -->
			</div>
			<div align="center">
				<ul class="pagination" id="jqPaginator"></ul>
			</div>
		</div>
	</div>
	<%@ include file="/commons/footer.jsp"%>
</body>
<script type="text/javascript">

(function ($) {
    'use strict';

    $.jqPaginator = function (el, options) {
        if(!(this instanceof $.jqPaginator)){
            return new $.jqPaginator(el, options);
        }

        var self = this;

        self.$container = $(el);

        self.$container.data('jqPaginator', self);

        self.init = function () {

            if (options.first || options.prev || options.next || options.last || options.page) {
                options = $.extend({}, {
                    first: '',
                    prev: '',
                    next: '',
                    last: '',
                    page: ''
                }, options);
            }

            self.options = $.extend({}, $.jqPaginator.defaultOptions, options);

            self.verify();

            self.extendJquery();

            self.render();

            self.fireEvent(this.options.currentPage, 'init');
        };

        self.verify = function () {
            var opts = self.options;

            if (!self.isNumber(opts.totalPages)) {
                throw new Error('[jqPaginator] type error: totalPages');
            }

            if (!self.isNumber(opts.totalCounts)) {
                throw new Error('[jqPaginator] type error: totalCounts');
            }

            if (!self.isNumber(opts.pageSize)) {
                throw new Error('[jqPaginator] type error: pageSize');
            }

            if (!self.isNumber(opts.currentPage)) {
                throw new Error('[jqPaginator] type error: currentPage');
            }

            if (!self.isNumber(opts.visiblePages)) {
                throw new Error('[jqPaginator] type error: visiblePages');
            }

            if (!opts.totalPages && !opts.totalCounts) {
                throw new Error('[jqPaginator] totalCounts or totalPages is required');
            }

            if (!opts.totalPages && opts.totalCounts && !opts.pageSize) {
                throw new Error('[jqPaginator] pageSize is required');
            }

            if (opts.totalCounts && opts.pageSize) {
                opts.totalPages = Math.ceil(opts.totalCounts / opts.pageSize);
            }

            if (opts.currentPage < 1 || opts.currentPage > opts.totalPages) {
                throw new Error('[jqPaginator] currentPage is incorrect');
            }

            if (opts.totalPages < 1) {
                throw new Error('[jqPaginator] totalPages cannot be less currentPage');
            }
        };

        self.extendJquery = function () {
            $.fn.jqPaginatorHTML = function (s) {
                return s ? this.before(s).remove() : $('<p>').append(this.eq(0).clone()).html();
            };
        };

        self.render = function () {
            self.renderHtml();
            self.setStatus();
            self.bindEvents();
        };

        self.renderHtml = function () {
            var html = [];

            var pages = self.getPages();
            for (var i = 0, j = pages.length; i < j; i++) {
                html.push(self.buildItem('page', pages[i]));
            }

            self.isEnable('prev') && html.unshift(self.buildItem('prev', self.options.currentPage - 1));
            self.isEnable('first') && html.unshift(self.buildItem('first', 1));
            self.isEnable('statistics') && html.unshift(self.buildItem('statistics'));
            self.isEnable('next') && html.push(self.buildItem('next', self.options.currentPage + 1));
            self.isEnable('last') && html.push(self.buildItem('last', self.options.totalPages));

            if (self.options.wrapper) {
                self.$container.html($(self.options.wrapper).html(html.join('')).jqPaginatorHTML());
            } else {
                self.$container.html(html.join(''));
            }
        };

        self.buildItem = function (type, pageData) {
            var html = self.options[type]
                .replace(/{{page}}/g, pageData)
                .replace(/{{totalPages}}/g, self.options.totalPages)
                .replace(/{{totalCounts}}/g, self.options.totalCounts);

            return $(html).attr({
                'jp-role': type,
                'jp-data': pageData
            }).jqPaginatorHTML();
        };

        self.setStatus = function () {
            var options = self.options;

            if (!self.isEnable('first') || options.currentPage === 1) {
                $('[jp-role=first]', self.$container).addClass(options.disableClass);
            }
            if (!self.isEnable('prev') || options.currentPage === 1) {
                $('[jp-role=prev]', self.$container).addClass(options.disableClass);
            }
            if (!self.isEnable('next') || options.currentPage >= options.totalPages) {
                $('[jp-role=next]', self.$container).addClass(options.disableClass);
            }
            if (!self.isEnable('last') || options.currentPage >= options.totalPages) {
                $('[jp-role=last]', self.$container).addClass(options.disableClass);
            }

            $('[jp-role=page]', self.$container).removeClass(options.activeClass);
            $('[jp-role=page][jp-data=' + options.currentPage + ']', self.$container).addClass(options.activeClass);
        };

        self.getPages = function () {
            var pages = [],
                visiblePages = self.options.visiblePages,
                currentPage = self.options.currentPage,
                totalPages = self.options.totalPages;

            if (visiblePages > totalPages) {
                visiblePages = totalPages;
            }

            var half = Math.floor(visiblePages / 2);
            var start = currentPage - half + 1 - visiblePages % 2;
            var end = currentPage + half;

            if (start < 1) {
                start = 1;
                end = visiblePages;
            }
            if (end > totalPages) {
                end = totalPages;
                start = 1 + totalPages - visiblePages;
            }

            var itPage = start;
            while (itPage <= end) {
                pages.push(itPage);
                itPage++;
            }

            return pages;
        };

        self.isNumber = function (value) {
            var type = typeof value;
            return type === 'number' || type === 'undefined';
        };

        self.isEnable = function (type) {
            return self.options[type] && typeof self.options[type] === 'string';
        };

        self.switchPage = function (pageIndex) {
            self.options.currentPage = pageIndex;
            self.render();
        };

        self.fireEvent = function (pageIndex, type) {
            return (typeof self.options.onPageChange !== 'function') || (self.options.onPageChange(pageIndex, type) !== false);
        };

        self.callMethod = function (method, options) {
            switch (method) {
                case 'option':
                    self.options = $.extend({}, self.options, options);
                    self.verify();
                    self.render();
                    break;
                case 'destroy':
                    self.$container.empty();
                    self.$container.removeData('jqPaginator');
                    break;
                default :
                    throw new Error('[jqPaginator] method "' + method + '" does not exist');
            }

            return self.$container;
        };

        self.bindEvents = function () {
            var opts = self.options;

            self.$container.off();
            self.$container.on('click', '[jp-role]', function () {
                var $el = $(this);
                if ($el.hasClass(opts.disableClass) || $el.hasClass(opts.activeClass)) {
                    return;
                }

                var pageIndex = +$el.attr('jp-data');
                if (self.fireEvent(pageIndex, 'change')) {
                    self.switchPage(pageIndex);
                }
            });
        };

        self.init();

        return self.$container;
    };

    $.jqPaginator.defaultOptions = {
        wrapper: '',
        first: '<li class="first"><a href="javascript:;">First</a></li>',
        prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
        next: '<li class="next"><a href="javascript:;">Next</a></li>',
        last: '<li class="last"><a href="javascript:;">Last</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        totalPages: 0,
        totalCounts: 0,
        pageSize: 0,
        currentPage: 1,
        visiblePages: 7,
        disableClass: 'disabled',
        activeClass: 'active',
        onPageChange: null
    };

    $.fn.jqPaginator = function () {
        var self = this,
            args = Array.prototype.slice.call(arguments);

        if (typeof args[0] === 'string') {
            var $instance = $(self).data('jqPaginator');
            if (!$instance) {
                throw new Error('[jqPaginator] the element is not instantiated');
            } else {
                return $instance.callMethod(args[0], args[1]);
            }
        } else {
            return new $.jqPaginator(this, args[0]);
        }
    };

})(jQuery);

var menuSecond=[];
var model = {  
        pageIndex: 1,      //索引页  
        pageSize: 6,      //每页列表的行数  
        //filterCounts: 1,   //筛选后的总行数  
        pageCount: 10,//总页数
        mid:1,
        minPrice:0,
        maxPrice:500000,
};
$(document).ready(function () {  
	getmenu();
	upload(1);
});

//分页器
function paginator(pageIndex, pageSize, pageCount) {
	$.jqPaginator('#jqPaginator',{
		totalPages : pageCount,
		visiblePages : 5,
		currentPage : pageIndex,
		pageSize : pageSize,
		first : '<li><a href="javascript:void(0);">首页<\/a><\/li>',
		prev : '<li><a href="javascript:void(0);">上一页<\/a><\/li>',
		next : '<li><a href="javascript:void(0);">下一页<\/a><\/li>',
		last : '<li><a href="javascript:void(0);">尾页<\/a><\/li>',
		page : '<li><a href="javascript:void(0);">{{page}}<\/a><\/li>',
		onPageChange : function(n, type) {
			if (type == 'change' && n != model.pageIndex) {
				model.pageIndex = n; //点击改变页码时，同步model中的页码  
				let mmid=model.mid;
				upload(mmid);//重新生成新表  
			}
		}
	});
	
};
function searchPrice(){
	model.minPrice=$('#minPrice').val();
	model.maxPrice=$('#maxPrice').val();
	if( model.maxPrice > model.minPrice){
		upload(model.mid);
	}else{
		alert("请填写正确的金额范围"+model.minPrice+"zz"+model.maxPrice);
	}
	
};
function upload(mid){
	$.ajax({
		type:"get",
		url:"CommodityServlet?method=CommodityByType",
		data:{
			"menuid":mid,
			"pageIndex": model.pageIndex,
			"minPrice":model.minPrice,
			"maxPrice":model.maxPrice,
			}, 
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		success:function(data) {
			console.log(data);
			if (data[0].pageCount == 0 ) {
                //model.filterCounts = 1;
        	}else{
        		model.pageSize = data[0].pageSize;
                model.pageCount = data[0].pageCount;
                model.pageIndex = data[0].pageIndex;
        	}
			paginator(model.pageIndex, model.pageSize,
					model.pageCount);
			$("#commodity").empty();
			let comdlist = data[0].rebList;
		
			for(var i = 0; i < comdlist.length; i++){
				$("#commodity").append("<div class='col-sm-6 col-md-4'><a href="+"CommodityServlet?method=GetCdityById&&menuid="+comdlist[i].id+" ><div class='thumbnail'><img src='"+comdlist[i].url+"'><div class='caption'><h3 style='color:black;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;'>"+comdlist[i].brand+"&nbsp;"+comdlist[i].model+"</h3><p class='prcieNum'>￥"+comdlist[i].price+"</p><p><a href='CommodityServlet?method=addToCartInside&id="+comdlist[i].id+"' class='btn btn-primary addToCart' role='button'><span class='glyphicon glyphicon-shopping-cart' aria-hidden='true'></span> 加入购物车</a><a href='#' class='btn btn-default' role='button'> <span class='glyphicon glyphicon-star' aria-hidden='true' style='color:#FF8F1C;'></span> 收藏</a></p></div></div></a></div>");
			}

		},
	});
};
function getmenu(){
		$.ajax({
			type:"get",
			url:"MenuServlet?method=MenuFirst",
			data:{
				}, 
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			success:function(data) {
				console.log(data)
			},
			});
}
$(function(){
	  $("#back-to-top").click(function() {
	      $("html,body").animate({scrollTop:0}, 500);
	  }); 
	 })
	var mySwiper = new Swiper ('.swiper-container', {
	autoplay: true,//可选选项，自动滑动
  	direction: 'horizontal', // 垂直切换选项
  	loop: true, // 循环模式选项
  // 如果需要滚动条
  scrollbar: {
    el: '.swiper-scrollbar',
    draggable: true,
  },
});
mySwiper.scrollbar.$dragEl.css('background','#777777'); 
/* $(function(){
	$("#pageNo").change(function(){
		var val = $(this).val();
		val = $.trim(val);
		
		//1. 校验 val 是否为数字 1, 2, 而不是 a12, b
		var flag = false;
		var reg = /^\d+$/g;
		var pageNo = 0;
		
		if(reg.test(val)){
			//2. 校验 val 在一个合法的范围内： 1-totalPageNumber
			pageNo = parseInt(val);
			if(pageNo >= 1 && pageNo <= parseInt("${computerpage.totalPageNumber }")){
				flag = true;
			}
		}
		if(!flag){
			
			$(".alert").alert();
			$(this).val("");
			return;
		}
		//3. 页面跳转
		var href = "computerServlet?method=getComputers&pageNo=" + pageNo + "&" + $(":hidden").serialize();
		window.location.href = href;
	});
}) */
function getListByType(type){
	model.mid=type;
	$(".secondmenu").css("display","none");
	upload(model.mid);
};
$(function(){
 	for (let i = 1;i <= 10;i++) {
 		$('#menu'+i).hover(function(){
 			$('#menu'+i).removeClass('add');
 			$('#menu'+i).addClass('addselect');
 			$(".secondmenu").css("display","block");
 			$(".secondmenu").html('');
 			$(".secondmenu").html("<img src='./public/img/menu"+i+".png' class='menu-img'>");
 			$.ajax({
 				type:"get",
 				url:"MenuServlet?method=MenuSecondByType",
 				data:{
 					menuid:i
 					}, 
 				dataType: "json",
 				contentType: "application/json; charset=utf-8",
 				success:function(data) {
 					for (var j=0;j<data.length;j++){
 			 			$(".secondmenu").append(
 			 					"<div class='menu-type' onClick="+"getListByType("+data[j].md_id+")"+ " ><div class='icon'><div class='text_c'>"+data[j].md_name+"</div></div><div class='menu-detail-content'>"+data[j].m_info+"</div></div>"
 			 				);
 					}
 				},
 			});
 			$(".secondmenu").unbind();
 			$(".secondmenu").hover(function(){
 				$(".secondmenu").css("display","block");
 				$('#menu'+i).removeClass('add');
 				$('#menu'+i).addClass('addselect');
 			},function(){
 				$(".secondmenu").css("display","none");
 				$('#menu'+i).addClass('add');
 				$('#menu'+i).removeClass('addselect');
 			});
 			
 		},function(){
 			$(".secondmenu").css("display","none");
 			$('#menu'+i).removeClass('addselect');
 			$('#menu'+i).addClass('add',true);
 		})
 	}
 })
</script>
</html>