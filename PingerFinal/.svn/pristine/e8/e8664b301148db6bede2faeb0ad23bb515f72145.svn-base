
describe("this is how pingerViewModel should behave", function(){
		
	var pinger;
	var pingerViewModel;
	var oConfig = {
				timeout : 5000,
				processingTime : 6000,
				url : "RequestServlet"
			};
	
	beforeEach(function(){
		pinger = jasmine.createSpyObj('Pinger',['ping','addListener']);	
		pingerViewModel = new PingerViewModel(pinger, oConfig);
	});
	
	it("calls ping and addListener", function(){
		//When
		pingerViewModel.press();
		
		//Then
		expect(pinger.ping).toHaveBeenCalled();
		expect(pinger.addListener).toHaveBeenCalled();
	});
	
});



