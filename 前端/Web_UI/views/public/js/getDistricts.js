 /** 省市区三级代码查询 **/
  var DISTRICTS;
     var provinceCode = '',
         cityCode = '',
         districtCode = '';
     //筛选的地区
     var province_selector = $('#province_selector'),
         city_selector = $('#city_selector'),
         district_selector = $('#district_selector');
     var htm = '<option value="">----请选择-----</option>';
     $.ajax({
         type: 'GET',
         url: '/public/js/districts.json',
         dataType: 'json'
     }).done(function (res) {
         DISTRICTS = res;
         htm = '<option value="">----请选择-----</option>';
         for(var key in DISTRICTS['100000']) {
             htm += '<option value="'+key+'">'+DISTRICTS['100000'][key]+'</option>';
         }
				 province_selector.html(123);
         province_selector.html(htm);
         city_selector.html('<option value="">----请选择-----</option>');
         district_selector.html('<option value="">----请选择-----</option>');
    }).fail(function () {
         console.log('获取地区json数据失败');
     });
 
     province_selector.change(function () {
         provinceCode =province_selector.find('option:selected').val();
         console.log(provinceCode);
         htm = '<option value="">----请选择-----</option>';
         for(var key in DISTRICTS[provinceCode]) {
             htm += '<option value="'+key+'">'+DISTRICTS[provinceCode][key]+'</option>';
         }
         city_selector.html(htm);
         district_selector.html('<option value="">----请选择-----</option>');
     });
     city_selector.change(function () {
         cityCode =city_selector.find('option:selected').val();
         console.log(cityCode);
         htm = '<option value="">----请选择-----</option>';
         for(var key in DISTRICTS[cityCode]) {
             htm += '<option value="'+key+'">'+DISTRICTS[cityCode][key]+'</option>';
						  district_selector.html(htm);
         }
     });
     district_selector.change(function () {
         districtCode =district_selector.find('option:selected').val();
         console.log(districtCode);
     });