//
//  request.swift
//  CAMO_App
//
//  Created by 지찬우 on 2022/09/27.
//

import Foundation
import UIKit

struct Response: Codable {
    let success: Bool
    let result: String
    let message: String
}

