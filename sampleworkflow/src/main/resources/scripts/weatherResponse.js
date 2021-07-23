var statusCode = connector.getVariable('statusCode');
print("status for weather", statusCode);
var res = S(response, 'application/json');;
print("Weather response: ",res);
connector.setVariable("weather",res.toString());
