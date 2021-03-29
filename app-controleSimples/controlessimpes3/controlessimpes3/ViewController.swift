//
//  ViewController.swift
//  controlessimpes3
//
//  Created by Igor Pino de Souza on 22/07/20.
//  Copyright © 2020 igorps. All rights reserved.
//

import UIKit
import FBSDKCoreKit
import FacebookCore
import FacebookLogin
import FBSDKLoginKit

class ViewController: UIViewController {

    @IBOutlet weak var valorDigitado: UITextField!
    @IBOutlet weak var receitaOuDespesa: UISegmentedControl!
    @IBOutlet weak var labelErro: UILabel!
    
    
    var timestamp = Date()
    

    // Swift override func viewDidLoad() { super.viewDidLoad() if let token = AccessToken.current, !token.isExpired { // User is logged in, do work such as go to next view controller. } }
        
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func loginWithFacebook(_ sender: Any) {
        let manager = LoginManager()
        manager.logIn(permissions: [.publicProfile, .email], viewController: self) { (result) in
            switch result {
            case .cancelled:
                print("Cancelled")
                break
            case .failed(let error):
                print("Error here: \(error.localizedDescription)")
                break
            case .success(let grantedPermissions, let declinedPermissions, let accessToken):
                print("Access Token: \(accessToken.appID), \(accessToken.userID), \(accessToken.expirationDate)")
            }
        }
        // Create request for user's Facebook data
        let request = GraphRequest(graphPath: "me", parameters: ["fields":"id,name,email"], httpMethod: .get)

        // Send request to Facebook
        request.start {

            (connection, result, error) in

            if error != nil {
                // Some error checking here
            }
            else if let userData = result as? [String:AnyObject] {

                // Access user data
                let username = userData["name"] as? String
                let userEmail = userData["email"]
                print(username!)
                print(userEmail!)
                
            }
        }
        
    }
    
//    func getUserProfile() {
//        FBSDKGraphRequest *request = [[FBSDKGraphRequest alloc]
//            initWithGraphPath:@"/me"
//                   parameters:@{ @"fields": @"id,name",}
//                   HTTPMethod:@"GET"];
//        [request startWithCompletionHandler:^(FBSDKGraphRequestConnection *connection, id result, NSError *error) {
//            // Insert your code here
//        }];
//    }
    

    @IBAction func enviaValor(_ sender: UIButton) {
        var url: URL
        var json: [String: Any]
        guard valorDigitado.hasText else {
            labelErro.isHidden = false
            labelErro.text = "Digite um valor"
            print(receitaOuDespesa.selectedSegmentIndex)
            return
        }
        if let valor = Double(valorDigitado.text!) {
            labelErro.isHidden = true
            valorDigitado.text = ""
            if (receitaOuDespesa.selectedSegmentIndex == 0) {
                url = URL(string: "https://controlesimples.herokuapp.com/receita")!
                json = ["valorReceita":valor]
            } else {
                url = URL(string: "https://controlesimples.herokuapp.com/despesa")!
                json = ["valorDespesa":valor]
            }
            postValor(valor, url, json)
        }
        view.endEditing(true)
        // performSegue(withIdentifier: "seg1", sender: nil)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        view.endEditing(true)
    }
    
    
    // GET
    func puxaGET() {
    let url = URL(string: "https://controlesimples.herokuapp.com/receita")!

    let task = URLSession.shared.dataTask(with: url) {(data, response, error) in
        guard let data = data else { return }
        print(String(data: data, encoding: .utf8)!)
    }

    task.resume()
    }

    // POST

    func postValor(_ valor: Double,_ url: URL, _ json: [String: Any]) {
    let jsonData = try? JSONSerialization.data(withJSONObject: json)
    var request = URLRequest(url: url)
    request.httpMethod = "POST"
    request.httpBody = jsonData

    request.setValue("application/json", forHTTPHeaderField: "Content-Type")

    let task = URLSession.shared.dataTask(with: request) { data, response, error in
        guard let data = data, error == nil else {
            print(error?.localizedDescription ?? "No data")
            return
        }
        let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
        if let responseJSON = responseJSON as? [String: Any] {
            print(responseJSON)
        }
    }

    task.resume()
        
    }
    
}

