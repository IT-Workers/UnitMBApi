
'use strict';
/**
 * init
 */
var angular_material = angular.module('app', ['ui.router', 'oc.lazyLoad', 'ngMaterial', 'ngMessages']);

/**
 * angular_material  config
 */
angular_material.config(['$stateProvider', '$controllerProvider', function($stateProvider,$controllerProvider){
	
	angular_material.controller = $controllerProvider.register;
	
	$stateProvider.state('/', {
        url: '',
        views: {
            'main': {
                templateUrl: 'login/views/login.html',
                controller: "login",
                resolve:resolve(["login/js/LoginController.js", 'login/css/login.css'])
            }
        }
    }).state('home', {
        url: '/',
        views: {
            'main': {
                templateUrl: 'home/views/home.html',
                controller: "home",
                resolve:resolve(["home/js/HomeController.js",'home/css/home.css'])
            }
        }
    }).state('home.doc', {
        url: 'doc?id',
        views: {
            'doc': {
                templateUrl: 'doc/views/doc.html',
                controller: "doc",
                resolve:resolve(["doc/js/DocController.js",'doc/css/doc.css'])
            }
        }
    });
}]);
/**
 * load file
 * @param files
 * @returns
 */
function resolve(files){
	return {
		 loadMyCtrl:['$ocLazyLoad',function ($ocLazyLoad) {
             return $ocLazyLoad.load({
                 files:files
             })
       	}]
	}
}
/**
 * service
 */
angular_material.service('$UnitMBHttp', function($http, $mdToast, $mdDialog) {
	/**
	 * 处理返回结果之前
	 */
	function before(res){
		//console.log(res);
	};
	function before(data, status, headers, config){
		//console.log(data, status, headers, config);
	};
	/**
	 * 处理返回结果之后
	 */
	function after(res){
		//console.log(res);
	};
	function before(data, status, headers, config){
		var type = data.promptType;
		if(type){
			showMessage(type, data.message);
		}
	};
	function showMessage(type, message){
		if('alert' == type){
			var alert = $mdDialog.alert({
				title: '错误',
				textContent: message,
				ok: '关闭'
			});
			$mdDialog.show(alert).finally(function() {
				alert = undefined;
	        });
		}else if('toast' == type){
			$mdToast.show($mdToast.simple()
				.textContent(message)
				.position("top right")
				.hideDelay(1000)
				.toastClass('from-success')
			);
		}else if('dialog' == type){
			
		}
	}
	/**
	 * 请求返回对象
	 */
	var Response = function (http){
		this.http = http;
		this.then = function(success, error, notify){
			this.http.then(function resSuccess(res){
				before(res);
				success(res);
				after(res)
			}, function resError(res){
				before(res);
				error(res);
				after(res)
			}, function resNotify(res){
				before(res);
				notify(res);
				after(res)
			});
		};
		this.error = function(error){
			return this.http.error(function(data, status, headers, config){
				before(data, status, headers, config);
				error(data, status, headers, config)
				after(data, status, headers, config)
			});
		};
		this.success = function(success){
			return this.http.success(function(data, status, headers, config){
				before(data, status, headers, config);
				success(data, status, headers, config)
				after(data, status, headers, config)
			});
		};
	};
	this.http = function(options){
		if(options){
			return new Response($http(options));
		}
		throw "http options is not a valid !";
	};
	/**
	 * http get 请求
	 */
	this.get = function(url, options){
		if(options){
			return new Response($http.get(url, options));
		}
		return new Response($http.get(url));
	};
	/**
	 * http head 请求
	 */
	this.head = function(url, options){
		if(options){
			return new Response($http.head(url, options));
		}
		return new Response($http.head(url));
	};
	/**
	 * http delete 请求
	 */
	this.delete = function(url, options){
		if(options){
			return new Response($http.delete(url, options));
		}
		return new Response($http.delete(url));
	};
	/**
	 * http jsonp 请求
	 */
	this.jsonp = function(url, options){
		if(options){
			return new Response($http.jsonp(url, options));
		}
		return new Response($http.jsonp(url));
	};
	/**
	 * http post 请求
	 */
	this.post = function(url, data, options){
		if(options){
			return new Response($http.post(url, JSON.stringify(data), options));
		}
		return new Response($http.post(url, JSON.stringify(data)));
	};
	/**
	 * http put 请求
	 */
	this.put = function(url, options){
		if(options){
			return new Response($http.put(url, JSON.stringify(data), options));
		}
		return new Response($http.put(url, JSON.stringify(data)));
	};
	
	/**
	 * http post 请求
	 */
	this.postFrom = function(url, data, options){
		if(!options){
			options = {};
		}
		options.headers = {
			'Accept':"text/html, */*",
			'Content-Type':"application/x-www-form-urlencoded;charset=utf-8"	
		};
		return new Response($http.post(url, formData(data), options));
	};
	/**
	 * 数据转成 from data 格式 key1=val1&key2=val2
	 */
	function formData(data){
		if(!data) return "";
		if(angular.isArray(data)){
			return arrayForKeyVal(data);
		}else if(angular.isObject(data)){
			return objForKeyVal(data);
		}else{
			return data;
		} 
	}
	/**
	 * obj to key1=val1&key2=val2
	 */
	function objForKeyVal(obj){
		var param = "";
		for(var key in obj){
			var item = obj[key];
			if(angular.isArray(item)){
				param += arrayForKeyVal(item);
			}else if(angular.isObject(item)){
				param += objForKeyVal(item);
			}else{
				param += key + "=" + obj[key]+"&";
			}
		}
		return param.substring(0, param.length - 1);
	}
	/**
	 * arr to key1=val1&key2=val2
	 */
	function arrayForKeyVal(arr){console.log(arr);
		for(var i in arr){
			var item = arr[i];
			if(angular.isArray(item)){
				arr[i] = arrayForKeyVal(item);
			}else if(angular.isObject(item)){
				arr[i] = objForKeyVal(item);
			}
		}
		return arr.join('&');
	}
});










