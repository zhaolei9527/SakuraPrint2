var cgSelectImport={
	sss:0,
	/* 点击快选获取内容 */ 
	$:function (id) {
	    var dom = document.getElementById(id);

	    var result = {
	        html:function(str){
	            if(typeof str == 'string') {
	                dom.innerHTML = str;
	                return str;
	            } else 
	                return dom.innerHTML;
	        },
	        val:function(str){
	        	var t = (typeof str);
	            if(t== 'string'|| t== 'number') {
	                dom.value = str;
	                return str;
	            } else 
	                return dom.value;
	        },
	        che:function(str){
	            if(typeof str== 'number') {
	                dom.checked = str==1?true:false;
	                return dom.checked;
	            } else 
	                return dom.checked;
	        },
	        hide:function(){
	        	//console.log('=' + (typeof dom));
	            if(typeof dom== 'object') {
	                dom.style.display = 'none';
	                return 'none';
	            } else 
	                return dom;
	        },
	        show:function(){
	            if(typeof dom== 'object') {
	                dom.style.display = '';
	                return '';
	            } else 
	                return dom;
	        },
	        isShow:function(){
	            if((typeof dom) == 'object') {
	            	if(dom.style.display!='none'){
	            		return true;
	            	}else{
	            		return false;
	            	}
	            } else 
	                return false;
	        },
	        Click:function(){
	            if((typeof dom) == 'object') {
	            	dom.click();
	            	return true;
	            } else 
	                return false;
	        }
	    }
	    return result;

	}
	,isNull:function (data){ 
		return (data == "" || data == undefined || data == null) ? false : true; 
	}

	,getCheVal:function (t){
		var v = t.value;
		var s = 0;
		if(t.checked){
			s=1;
		}
		cgSelectImport.$('cyid'+v).val(s+'-'+v);
	}
	,parsing:function (classid,str){
		//str = decodeURIComponent(str);
		var sarr = new Array(19);
		var sarr = str.split('|');
		this.__classid=classid;
		if(this.__classid<=3){
			this.$('__dingwei_qu').Click();
		}
		//定位
		if(this.$("s3").isShow()){
			arr = this.getArray(sarr['0']);
			if(arr!=false){				
				if(arr[0]==1)this.$('__dingwei_chu').che(1);
				if(arr[1]==1)this.$('__dingwei_qu').che(1);
				var ii=0;
				for(var i=1;i<=4;i++){
					ii=i+1;
					this.$("__dingwei_"+i).val(arr[ii]);
				}
			} 
		}
		//合分
		if(this.$("s5").isShow()){
			arr = this.getArray(sarr['1']);
			if(arr!=false){					
				if(arr[0]==1)this.$('__hefen_chu').che(1);
				if(arr[1]==1)this.$('__hefen_qu').che(1);
				var jj=0;var jjj=1;
				for (j=2;j<=21;j++){
					jj++;
					if(jj<=4){
						if(arr[j]==1)this.$('__hefenzhide_w_'+jj+''+jjj).che(1);
					}else if (jj==5){
						if(this.isNull(arr[j]))this.$("__hefenzhide_"+jjj).val(arr[j]);
						jj=0;jjj++;
					}
				}
				
			}
		}		
		//不定位合分
		if(this.$("s6").isShow()){
			arr = this.getArray(sarr['2']);
			if(arr!=false){		
				if(arr[0]==1)this.$('__bdwhefen_1').che(1);
				if(arr[1]==1 && this.__classid != 1 && this.__classid !=4 )this.$('__bdwhefen_2').che(1);
				if(this.isNull(arr[2]))this.$("__bdwhefen").val(arr[2]);
				
			}
		}
		//值范围
		if(this.$("zfw1").isShow()&&this.__classid ==3){
			arr = this.getArray(sarr['3']);
			if(arr!=false){		
				if(this.isNull(arr[0]))this.$("__zhifanwei_start").val(arr[0]);
				if(this.isNull(arr[1]))this.$("__zhifanwei_end").val(arr[1]);
			}
			
		}		
		//全转 上奖 排除
		if( this.__classid <= 3 ){
			arr = this.getArray(sarr['4']);
			if(arr!=false){		
				if(this.isNull(arr[0]))this.$("__quandao").val(arr[0]);
				if(this.isNull(arr[1]))this.$("__shangjiang").val(arr[1]);
				if(this.isNull(arr[2]))this.$("__paichu").val(arr[2]);
			}
			
		}
		//乘号位置
		if( this.$("ch1").isShow() && this.__classid <= 2 ){
			arr = this.getArray(sarr['5']);
			if(arr!=false){
				var ii=0;
				for(var i=1;i<=4;i++){
					if(arr[ii]==1)this.$('__chenghao_'+i).che(1);
					ii++;
				}	
			}


		}
		//复式
		if(this.$("han"+this.__classid).isShow()){
			arr = this.getArray(sarr['6']);
			if(arr!=false){
				if(arr[0]==1)this.$('__chu_'+this.__classid).che(1);
				if(arr[1]==1)this.$('__qu_'+this.__classid).che(1);
				if(this.isNull(arr[2]))this.$("__han_"+this.__classid).val(arr[2]);
				if(this.isNull(arr[3]))this.$("__fushi_"+this.__classid).val(arr[3]);

			}
		}
		//重
		if(this.$("s8").isShow()){
			var ii=7;
			for(var i=1;i<=4;i++){
				arr = this.getArray(sarr[ii]);
				if(arr!=false){
					if(this.$("ss"+i).isShow()){
						if(arr[0]==1)this.$('__chu_chong_'+i).che(1);
						if(arr[1]==1)this.$('__qu_chong_'+i).che(1);
					}
				}
				ii++;
			}
		}		
		//兄弟
		if(this.$("s9").isShow()){
			var ii=11;var j=1;
			for(var i=5;i<=7;i++){
				arr = this.getArray(sarr[ii]);
				if(arr!=false){
					if(this.$("ss"+i).isShow()){
						if(arr[0]==1)this.$('__chu_xiongdi_'+j).che(1);
						if(arr[1]==1)this.$('__qu_xiongdi_'+j).che(1);
					}
				}
				j++;
				ii++;
			}
		}
		//对数
		if(this.$("s10").isShow()){
			arr = this.getArray(sarr['14']);
			if(arr!=false){
				if(arr[0]==1)this.$('__chu_duishu').che(1);
				if(arr[1]==1)this.$('__qu_duishu').che(1);
				if(this.isNull(arr[2]))this.$('__duishu_1').val(arr[2]);
				if(this.isNull(arr[3]))this.$('__duishu_2').val(arr[3]);
				if(this.isNull(arr[4]))this.$('__duishu_3').val(arr[4]);

			}
		}
		//单
		if(this.$("dan1").isShow()){
			arr = this.getArray(sarr['15']);
			if(arr!=false){
				if(arr[0]==1)this.$('__dan_chu').che(1);
				if(arr[1]==1)this.$('__dan_qu').che(1);
				var ii=0;var iii=1;
				for(var i=1;i<=4;i++){
					if(this.__classid == 4 && i<=2){
						continue;
					}else if(this.__classid == 5 && i<=1){
						continue;
					}
					ii=iii+1;
					if(arr[ii]==1)this.$('__dan_'+i).che(1);
					iii++;
				}
			}
			
		}		
		//双
		if(this.$("shuang1").isShow()){
			arr = this.getArray(sarr['16']);
			if(arr!=false){
				if(arr[0]==1)this.$('__shuang_chu').che(1);
				if(arr[1]==1)this.$('__shuang_qu').che(1);
				var ii=0;var iii=1;
				for(var i=1;i<=4;i++){
					if(this.__classid == 4 && i<=2)continue;
					if(this.__classid == 5 && i<=1)continue;
					ii=iii+1;
					if(arr[ii]==1)this.$('__shuang_'+i).che(1);
					iii++;
				}
			}
			
		}
		//配数全转
		//if(this.$("s12").isShow()){
			arr = this.getArray(sarr['17']);
			if(arr!=false){
				var m='';
				if(this.__classid>3){
					m='2';
				}

				var p=0;
				if(this.isNull(arr[2])){
					this.$('__peishu_1').val(arr[2]);p=1;
				}
				if(this.isNull(arr[3])){
					this.$('__peishu_2').val(arr[3]);p=1;
				}
				if(this.isNull(arr[4])){
					this.$('__peishu_3').val(arr[4]);p=1;
				}
				if(this.isNull(arr[5])){
					this.$('__peishu_4').val(arr[5]);p=1;
				}
				if(arr[6]==1)this.$('__gd1').che(1);
				if(arr[7]==1)this.$('__gd2').che(1);
				if(arr[8]==1)this.$('__gd3').che(1);
				if(arr[9]==1)this.$('__gd4').che(1);
				if(arr[0]==1||arr[1]==1||p==1){
					this.$('__dingwei_chu').che(0); 
					this.$('__dingwei_qu').che(0);
				}
				if(arr[0]==1){
					this.$('__peishu_chu'+m).che(0); 
					this.$('__peishu_chu'+m).Click();
				}
				if(arr[1]==1||p==1){
					this.$('__peishu_qu'+m).che(0);
					this.$('__peishu_qu'+m).Click();
				}				
			}
		//}
		//常用热门码
		if(this.__classid==3 && this.$("__changyong").checked){
			arr = this.getArray(sarr['18']);
			if(arr!=false){
				if(arr[0]==1)this.$('__changyong').che(1);
			}
		}
		if(this.$('setsoonclass1'))this.$('setsoonclass1').Click();
		
	}
	,getArray:function (a){
		if(this.isNull(a)){
			arr=a.split(',');
			if(this.isNull(arr)){
				return arr;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
	,init:function (){
		

		//cgSelect.setVal();

	}
	
};
