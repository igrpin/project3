//
//  File.swift
//  controlesimples4
//
//  Created by Igor Pino de Souza on 02/09/20.
//  Copyright © 2020 igorps. All rights reserved.
//

import Foundation


class REST {
    
    private static let basePath = "https://controlesimples.herokuapp.com/receita"
    
    // Configurações da Sessão
    private static let configuration: URLSessionConfiguration = {
        let config = URLSessionConfiguration.default
        config.allowsCellularAccess = false
        config.httpAdditionalHeaders = ["Content-Type": "application/json"]
        config.timeoutIntervalForRequest = 30.0
        config.httpMaximumConnectionsPerHost = 5
        return config
    }()
    
    private static let session = URLSession(configuration: configuration)
    
    class func loadIncomes() {
        guard let url = URL(string: basePath) else {return}
        let dataTask = session.dataTask(with: url) { (data: Data?, response: URLResponse?, error: Error?) in
            if error == nil {
                guard let response = response as? HTTPURLResponse else {return}
                if response.statusCode == 200 {
                    guard let data = data else {return}
                    do {
                        let incomes = try JSONDecoder().decode([Income].self, from: data)
                        for inc in incomes {
                            if let i = inc.valorReceita {
                                print(i)
                            }
                        }
                    } catch {
                        print(error)
                    }
                }
            } else {
                print("Algum status inválido pelo servidor!")
            }
        }
        dataTask.resume()
    }
    
}
