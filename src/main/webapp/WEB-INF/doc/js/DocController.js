/**
 * @author Sun yan
 * @param $scope
 * @returns
 */
angular_material.controller('doc', function($scope, $state, $stateParams, $mdToast, $UnitMBHttp) {
	/**
	 * 文档ID
	 */
	var doc_id = $stateParams.id;
	$scope.urlPattern = 'http(s?)\:\/\/[0-9a-zA-Z]([-.\w]*[0-9a-zA-Z])*(:(0-9)*)*(\/?)([a-zA-Z0-9\-\.\?\,\'\/\\\+&amp;%\$#_]*)?$';
	/**
	 * 请求方式
	 */
	$scope.methodType=[
		{id:0,val:'GET'},{id:1,val:'POST'},{id:2,val:'PUT'},{id:3,val:'DELETE'}
	];
	/**
	 * 参数类型
	 */
	$scope.paramType=[
		{id:0,val:'Int'},
		{id:1,val:'Long'},
		{id:2,val:'Double'},
		{id:3,val:'String'},
		{id:4,val:'Boolean'},
		{id:5,val:'Date'},
		{id:6,val:'Object'},
		{id:7,val:'Array'}
	];
	/**
	 * 获取文档详情
	 */
	$UnitMBHttp.postFrom('doc/detail', $stateParams).success(function(data, status, headers, config){
		$scope.document = data.data;
	});
	/**
	 * 保存和编辑文档详情
	 */
	function editDocument(document){
		$UnitMBHttp.postFrom('doc/edit', document).success(function(data, status, headers, config){
		});
	};
	/**
	 * 文档的编辑状态
	 */
	$scope.edit={
		detail:false,
		param:false,
		result:false,
		code:false
	};
	/**
	 * 错误提示
	 */
	var showError = function(message){
		$mdToast.show($mdToast.simple()
			.textContent(message)
			.position("top right")
			.hideDelay(1000)
			.toastClass('from-error')
		);
	};
	/**
	 * 编辑文档简介
	 */
	$scope.detailEdit = function(event, from){
		var spacer = angular.element(document.querySelectorAll("form[name='"+from.$name+"'] .md-errors-spacer"));
		if($scope.edit.detail && from.$valid){
			$scope.edit.detail = false;
			spacer.css('visibility', 'hidden');
			editDocument({
				documentId:$scope.document.documentId,
				description:$scope.document.description,
				httpUrl:$scope.document.httpUrl,
				methodType:$scope.document.methodType
			});
		}else if($scope.edit.detail && !from.$valid){
			showError('数据格式有误！');
			return false;
		}else{
			$scope.edit.detail = true;
			spacer.css('visibility', 'visible');
		}
	};
	/**
	 * 编辑code编码
	 */
	$scope.codeEdit = function(event, from){
		var spacer = angular.element(document.querySelectorAll("form[name='"+from.$name+"'] .md-errors-spacer"));
		if($scope.edit.code && from.$valid){
			$scope.edit.code = false;
			spacer.css('visibility', 'hidden');
			/*editDocument({
				documentId:$scope.document.documentId,
				description:$scope.document.description,
				httpUrl:$scope.document.httpUrl,
				methodType:$scope.document.methodType
			});*/
			console.log($scope.document.codes);
		}else if($scope.edit.code && !from.$valid){
			showError('数据格式有误！');
			return false;
		}else{
			$scope.edit.code = true;
			spacer.css('visibility', 'visible');
		}
	};
});