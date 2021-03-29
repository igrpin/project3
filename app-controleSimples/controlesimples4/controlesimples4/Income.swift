//
//  Income.swift
//  controlesimples4
//
//  Created by Igor Pino de Souza on 02/09/20.
//  Copyright © 2020 igorps. All rights reserved.
//

import Foundation

class Income: Codable {
    
    var id: Int
    var valorReceita: Double?
    var dataReceita: String
    var categoriaReceitaId: Int?    
}
