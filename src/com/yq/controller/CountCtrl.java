package com.yq.controller;

import com.google.gson.Gson;
import com.yq.entity.*;
import com.yq.service.*;
import com.yq.util.StringUtil;
//import jnr.ffi.Struct;
import net.sf.json.JSONObject;
//import org.python.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

//import org.python.util.PythonInterpreter;

@Controller
@RequestMapping
public class CountCtrl extends StringUtil {
	@Autowired
	private UserService userService;
	private User user = new User();
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;
	private Goods goods = new Goods();
	private Category category = new Category();
	@Autowired
	private CouponsService couponsService;
	private Coupons coupons = new Coupons();
	@Autowired
	private AddressService addressService;
	private Address address = new Address();
	@Autowired
	private FreightService freightService;
	private Freight freight = new Freight();
	@Autowired
	private CountService countService;
	private Count count = new Count();

	Map<String, Object> map = new HashMap<String, Object>();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value = "/main/goodsCount.html")
	public ModelAndView goodscCount(Integer goods_id, HttpSession session) {
	    String oppen_id = getOppen_id(session);

		Count count = new Count();
		List<Map<String, String>> list = countService.countByGoodsId(goods_id);

		ModelAndView ml = new ModelAndView();
		ml.addObject("list", list);
		ml.setViewName("main/goods/count");
		return ml;
	}

    @RequestMapping(value = "/main/goodsCountAll.html")
    public ModelAndView goodsCountAll(HttpSession session) {
        String oppen_id = getOppen_id(session);

        Count count = new Count();
//        List<Map<String, String>> list = countService.countByGoodsId(goods_id);

        ModelAndView ml = new ModelAndView();
//        ml.addObject("list", list);
        ml.setViewName("main/goods/countAll");
        return ml;
    }

	@RequestMapping(value = "/main/countDate.html")
	public ModelAndView countDate(HttpSession session) {
		String oppen_id = getOppen_id(session);

		Count count = new Count();
//        List<Map<String, String>> list = countService.countByGoodsId(goods_id);

		ModelAndView ml = new ModelAndView();
//        ml.addObject("list", list);
		ml.setViewName("main/goods/countDate");
		return ml;
	}


	/**
	 * 饼图计数
	 * @param start_time
	 * @param end_time
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/main/findCountData.html")
	public Object findcCountData(String start_time, String end_time) {
		Map<String, String> search = new HashMap<>();
		search.put("start_time", start_time);
		search.put("end_time", end_time);
		List<Map<String, String>> list = countService.findCountByDate(search);
		Map<String, String> data = new HashMap<>();
		List<Map> res  = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			data = list.get(i);
			String goods_name = data.get("goods_name");
			Map dataMap = new HashMap<>();
			dataMap.put("name", goods_name);
			String counts = String.valueOf(data.get("counts"));
			dataMap.put("value", Integer.parseInt(counts));
			res.add(dataMap);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("countData", res);
		String json = new Gson().toJson(map);
		JSONObject jsonObject = JSONObject.fromObject(json);
		String result = jsonObject.toString();
		return result;
	}


	/**
	 * 单品计数
	 * @param goods_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/main/countData.html")
	public Object countData(Integer goods_id) {
		List<Map<String, String>> list = countService.countByGoodsId(goods_id);
		Map<String, String> data = new HashMap<>();
		List<Map<String, String>> res  = new ArrayList<>();
//		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd" );
		for(int i = 0; i < list.size(); i++){
			data = list.get(i);
			String views = data.get("views");
//			String time = sdf.format(views);
			String count = String.valueOf(data.get("count"));
			Map<String, String> dataMap = new HashMap<>();
			dataMap.put("views", views);
			dataMap.put("count", count);
			res.add(dataMap);
  		}
//		for(int i=0; i < list.size(); i++){
//			String views = list.get(i).getViews();
//			String count = list.get(i).getCount();
//			map.put("countData", views);
//			map.put("count", count);
//		}
		Map<String, Object> map = new HashMap<>();
		map.put("countData", res);
		String json = new Gson().toJson(map);
		JSONObject jsonObject = JSONObject.fromObject(json);
		String result = jsonObject.toString();
		return result;
	}

	/**
	 * 分析计数
	 * @return
	 */
    @ResponseBody
    @RequestMapping(value = "/main/countDataAll.html")
    public Object countDataAll() {
        List<Map<String, String>> list = countService.countDataAll();
        Map<String, String> data = new HashMap<>();
        List<Map<String, String>> res  = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            data = list.get(i);
            String order_time = data.get("order_time");
            String count = String.valueOf(data.get("count"));
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("order_time", order_time);
            dataMap.put("count", count);
            res.add(dataMap);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("countData", res);
        String json = new Gson().toJson(map);
        JSONObject jsonObject = JSONObject.fromObject(json);
        String result = jsonObject.toString();
        return result;
    }

	/**
	 * DCU_test
	 */
	@RequestMapping(value = "/main/dcuTest.html")
	public ModelAndView dcuTest(HttpSession session) {
//		String result = python().toString();;
		ModelAndView ml = new ModelAndView();
//		ml.addObject("result", result);
		ml.setViewName("main/dcu/countAll");
		return ml;
	}

	/**
	 * Forecast
	 */
	@RequestMapping(value = "/main/forecast.html")
	public ModelAndView forecast(HttpSession session) throws IOException, InterruptedException {
//		String result = python().toString();
//		String result = cmd().toString();
		ModelAndView ml = new ModelAndView();
//		ml.addObject("result", result);
		ml.setViewName("main/dcu/forecast");
		return ml;
	}

	/**
	 * python执行类
	 */
//	public JSONObject python() {
//
//		String test = "John";
//		String test1 = "1";
//		String test2 = "2";
//		String test3 = "3";
//
//		String county = "Wexford";
//		String from_date = "2008-01-01 01:00:00";
//		String to_date = "2009-01-01 01:00:00";
//		String feature = "temp";
//		String predict_days = "20";
//
//		Map<String, String> data = new HashMap<>();
//		data.put("county", county);
//		data.put("from_date", from_date);
//		data.put("to_date", to_date);
//		data.put("feature", feature);
//		data.put("Integer", predict_days.toString());
//
//		List<String> list  = new ArrayList<>();
//		list.add(county);
//		list.add(from_date);
//		list.add(to_date);
//		list.add(feature);
//		list.add(predict_days.toString());
//
//
//		String result = null;
//
//		String finalResult = null;
//		String dir = System.getProperty("user.dir");
//		String filePath = dir + "/main.py";
//		PythonInterpreter interpreter = new PythonInterpreter();
//		interpreter = new PythonInterpreter();
//		interpreter.execfile(filePath);
//		PyFunction function = (PyFunction) interpreter.get("Main", PyFunction.class);
////		PyObject o = function.__call__((PyObject) list);
//		PyObject o = function.__call__(new PyString(county), new PyString(from_date), new PyString(to_date), new PyString(predict_days.toString()));
//		//TODO 添加预测类型参数
////		System.out.println("====================调用python脚本并读取结果为:" + o.toString() + "====================");
////		result = "Testing python file and get the result is :" + o.toString();
////		result = o.toString();
//		finalResult = o.toString();
//		JSONObject jsonObject = JSONObject.fromObject(finalResult);
////		String result = jsonObject.toString();
////		result = result.substring(0,result.length()-1);
//		return jsonObject;
//	}
	/**
	 * Python数据处理累类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/main/pyComputing.html")
	public Object pyComputing() {
		List<Map<String, String>> list = countService.countDataAll();
		Map<String, String> data = new HashMap<>();
		List<Map<String, String>> res  = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			data = list.get(i);
			String order_time = data.get("order_time");
			String count = String.valueOf(data.get("count"));
			Map<String, String> dataMap = new HashMap<>();
			dataMap.put("order_time", order_time);
			dataMap.put("count", count);
			res.add(dataMap);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("countData", res);
		String json = new Gson().toJson(map);
		JSONObject jsonObject = JSONObject.fromObject(json);
		String result = jsonObject.toString();
		return result;
	}

	/**
	 * JSON数据提供类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/main/jsonData.html")
	public Object jsonData(String county, String from_time, String to_time, String feature, String predict_days) throws IOException, InterruptedException {
//		List<Map<String, String>> list = countService.countDataAll();
//		Map<String, String> data = new HashMap<>();
//		List<Map<String, String>> res  = new ArrayList<>();
//		for(int i = 0; i < list.size(); i++){
//			data = list.get(i);
//			String order_time = data.get("order_time");
//			String count = String.valueOf(data.get("count"));
//			Map<String, String> dataMap = new HashMap<>();
//			dataMap.put("order_time", order_time);
//			dataMap.put("count", count);
//			res.add(dataMap);
//		}
//		Map<String, Object> map = new HashMap<>();
//		map.put("countData", res);
//		JSONObject data = python();
		JSONObject data = cmd(county, from_time, to_time, feature, predict_days);
		String json = new Gson().toJson(data);
		JSONObject jsonObject = JSONObject.fromObject(json);
		String result = jsonObject.toString();
		String temp = data.toString();
		return temp;
	}

	/**
	 * command results
	 */
	public JSONObject cmd(String county, String from_time, String to_time, String feature, String predict_days) throws IOException, InterruptedException {
		String[] arguments = new String[] { "python", "test3.py", county, from_time, to_time, feature, predict_days};

		Process process = Runtime.getRuntime().exec(arguments);
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = in.readLine();
//		while ((line = in.readLine()) != null) {
			System.out.println("========================"+line);
//		}
		in.close();
		int re = process.waitFor();
		// System.out.println("========================" + re);
		JSONObject jsonObject = JSONObject.fromObject(line);
		return jsonObject;
	}

}

