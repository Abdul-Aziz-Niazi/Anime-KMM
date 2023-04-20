//
//  AnimeViewModel.swift
//  iosApp
//
//  Created by Abdul Aziz on 20/04/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class AnimeViewModel : ObservableObject{
    let feedItemUseCase = FeedItemUseCaseImpl()
    @Published var feedItemList = [FeedItemData]()
    @Published var error = ""
    func getFeedItem() {
        let feedItemDataFlow = feedItemUseCase.getFeedItem(genre: "")
        FlowExtensionKt.asCompletion(feedItemDataFlow, result:{result, error in
            if error == nil {
                self.feedItemList = result as? [FeedItemData] ?? []
                print("Success ${self.feedItemList}")
            } else {
                self.error = error as? String ?? "Something went wrong"
                print(error ?? "something went wrong!")
            }
        })
    }
}
