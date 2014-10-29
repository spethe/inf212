//Heatmap

describe("this is how HeatMap application behaves", function() {

	it("displays instruments on application load", function(){
		//Given
		var container = new Container();
		
		var application = new HeatmapApplication(container, channel);
		var gold = {name:"Gold"};
		var platinum = {name:"Platinum"};
		var channel = new ChannelForTest([gold,platinum]);
		//When
		application.load();
		
		//Then
		expect(container.instruments[0]).toBe(gold);
		expect(container.instruments[1]).toBe(platinum);
	});
}