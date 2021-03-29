//
//  AppDelegate.swift
//  controlessimpes3
//
//  Created by Igor Pino de Souza on 22/07/20.
//  Copyright © 2020 igorps. All rights reserved.
//

import UIKit
import FBSDKCoreKit

@UIApplicationMain class AppDelegate: UIResponder, UIApplicationDelegate {
    func application( _ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? ) -> Bool { ApplicationDelegate.shared.application( application, didFinishLaunchingWithOptions: launchOptions )
        return true
        
    }
    
    func application( _ app: UIApplication, open url: URL, options: [UIApplication.OpenURLOptionsKey : Any] = [:] ) -> Bool { ApplicationDelegate.shared.application( app, open: url, sourceApplication: options[UIApplication.OpenURLOptionsKey.sourceApplication] as? String, annotation: options[UIApplication.OpenURLOptionsKey.annotation] )
        
    }
    
}

    

