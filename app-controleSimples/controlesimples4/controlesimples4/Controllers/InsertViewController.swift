//
//  InsertViewController.swift
//  controlesimples4
//
//  Created by Igor Pino de Souza on 02/09/20.
//  Copyright © 2020 igorps. All rights reserved.
//

import UIKit

class InsertViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        REST.loadIncomes()
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
