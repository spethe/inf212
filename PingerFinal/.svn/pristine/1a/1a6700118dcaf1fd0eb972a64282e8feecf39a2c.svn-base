describe("this is how pinger should behave", function() {

	var pinger;
	var mockPingerViewModel;
	var oConfig = {
		timeout : 5000,
		processingTime : 6000,
		url : "RequestServlet"
	};

	beforeEach(function() {
		mockPingerViewModel = jasmine.createSpyObj('PingerViewModel', ['onSuccess', 'onFailure']);
		pinger = new Pinger();
	});

	it("calls ping and addListener in case of success", function() {
		//When
		pinger.addListener(mockPingerViewModel);
		var fakeDataTime = "234";
		var fakeDataMessage = "Success";

		spyOn($, "ajax").andCallFake(function(param) {
			debugger;
			param.success(fakeDataTime, fakeDataMessage);
		});
		pinger.ping(oConfig);

		//Then
		expect(mockPingerViewModel.onSuccess).toHaveBeenCalled();
	});
	
	it("calls ping and addListener in case of error", function() {
		//When
		pinger.addListener(mockPingerViewModel);
		var fakeDataTime = "0";
		var fakeDataMessage = "Error";

		spyOn($, "ajax").andCallFake(function(param) {
			param.error(fakeDataTime, fakeDataMessage);
		});
		pinger.ping(oConfig);

		//Then
		expect(mockPingerViewModel.onFailure).toHaveBeenCalled();
	});

});

