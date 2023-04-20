import SwiftUI
import shared

struct ContentView: View {
    @EnvironmentObject var animeViewModel : AnimeViewModel

	let greet = Greeting().greet()
	init() {
        UITabBar.appearance().backgroundColor = UIColor(Color(hex: "#9C27B0"))
        UITabBar.appearance().barTintColor = UIColor(Color(hex: "#9C27B0"))
		UIScrollView.appearance().bounces = false

    }
    var body: some View {
        NavigationView {
            TabView {
                List(animeViewModel.feedItemList, id:\.title) { item in
                    HStack {
                        AsyncImage(url: URL(string: item.image ?? ""), content: { image in
                            image.resizable()
                                .clipShape(RoundedRectangle(cornerSize: CoreFoundation.CGSize.init(width: 8.0, height: 8.0)))
                                .aspectRatio(contentMode: .fit)
                                .frame(maxWidth: 120, maxHeight: 200)
                        }, placeholder:{
                            ProgressView()
                        })
                        VStack(alignment: .leading) {
                            Text(item.title ?? "").bold().font(.system(size: 26))
                            Text((item.genres as? [String])?.joined(separator: ", ") ?? "-").bold().font(.system(size: 12)).foregroundColor(Color(hex: "#FF3700B3"))
                            Text("Episodes: \(item.episodes ?? 0)").font(.system(size: 12))
                            Text(item.synopsis ?? "").lineLimit(3).font(.system(size: 12))
                        }
                    }.padding(.leading, 8)
                }.listStyle(PlainListStyle())
                .listRowInsets(EdgeInsets())
                .tabItem {
                    Image("Feed").renderingMode(.template).resizable().foregroundColor(.white)
                    Text("Feed")
                }
                
                List(0..<10) { item in
                    Text("Genre.Name")
                }
                .tabItem {
                    Image("Genre").renderingMode(.template).resizable().foregroundColor(.white)
                    Text("Genre")
                }
                
                HStack{
                    Text("Made with Compose, KMM, and Ktor. This app consumes the Anime API from Rapid API")
                }
                .tabItem {
                    Image("About").renderingMode(.template).resizable().foregroundColor(.white)
                    Text("About")
                }
            }
            .accentColor(.white)
            .onAppear {
                UITabBar.appearance().barTintColor = UIColor(Color(hex: "#9C27B0"))
                animeViewModel.getFeedItem()
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
