import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()
	init() {
        UITabBar.appearance().backgroundColor = UIColor(Color(hex: "#9C27B0"))
        UITabBar.appearance().barTintColor = UIColor(Color(hex: "#9C27B0"))
		UIScrollView.appearance().bounces = false

    }
    var body: some View {
        ZStack {
            Color.green.edgesIgnoringSafeArea(.all)
            
            TabView {
                List(0..<10) { item in
                    HStack {
                        Image(systemName: "person.fill")
                        VStack(alignment: .leading) {
                            Text("Title")
                            Text("Genre")
                            Text("Episodes")
                            Text("Description")
                        }
                    }
                }
                .tabItem {
                    Image("Feed").renderingMode(.template).resizable().foregroundColor(.white)
                    Text("Feed")
                }
                
                List(0..<10) { item in
                    Text("Genre.Name")
                }
                .tabItem {
                    Image(systemName: "2.square.fill")
                    Text("Genre")
                }
                
                HStack{
                    Text("About")
                }
                .tabItem {
                    Image(systemName: "3.square.fill")
                    Text("About")
                }
            }
            .accentColor(.white)
            .onAppear {
                UITabBar.appearance().barTintColor = UIColor(Color(hex: "#9C27B0"))
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

extension Color {
    init(hex: String) {
        let hex = hex.trimmingCharacters(in: CharacterSet.alphanumerics.inverted)
        var int: UInt64 = 0
        Scanner(string: hex).scanHexInt64(&int)
        let a, r, g, b: UInt64
        switch hex.count {
        case 3: // RGB (12-bit)
            (a, r, g, b) = (255, (int >> 8) * 17, (int >> 4 & 0xF) * 17, (int & 0xF) * 17)
        case 6: // RGB (24-bit)
            (a, r, g, b) = (255, int >> 16, int >> 8 & 0xFF, int & 0xFF)
        case 8: // ARGB (32-bit)
            (a, r, g, b) = (int >> 24, int >> 16 & 0xFF, int >> 8 & 0xFF, int & 0xFF)
        default:
            (a, r, g, b) = (1, 1, 1, 0)
        }

        self.init(
            .sRGB,
            red: Double(r) / 255,
            green: Double(g) / 255,
            blue:  Double(b) / 255,
            opacity: Double(a) / 255
        )
    }
}
