//
//  UTTextField.swift
//  CAMO
//
//  Created by 지찬우 on 2022/09/26.
//

import UIKit

public enum UTTextFieldStatus : Int {
    case Normal
    case Input
}

class UTTextField: UITextField {
    
    var upperLabel: UILabel!
    
    override func awakeFromNib() {
    
        // 클리어버튼의 색상변경하기
        let clearButton = self.valueForKey("_clear  Button") as! UIButton
        clearButton.tintColor = UIColor.whiteColor()
        
        let currentImage = clearButton.currentImage
        let renderedImage = currentImage?.imageWithRenderingMode(UIImageRenderingMode.AlwaysTemplate)
        clearButton.setImage(renderedImage, forState: UIControlState.Normal)
        
        // UITextField의 placeholder가 움직이는 것처럼 보이게 할 UILabel 정의
        self.upperLabel = UILabel(frame: CGRectZero)
        self.upperLabel.backgroundColor = UIColor.clearColor()
        self.upperLabel.textColor = UIColor(red: 253.0 / 255.0, green: 224.0 / 255.0, blue: 48.0 / 255.0, alpha: 1.0)
        self.upperLabel.text = self.placeholder
        self.upperLabel.font = UIFont.systemFontOfSize(10.0)
        self.upperLabel.translatesAutoresizingMaskIntoConstraints = false
        self.upperLabel.alpha = 0.0
        
        self.addSubview(self.upperLabel)
        
        // 위 UILabel의 autolayout 정의
        let topCon = NSLayoutConstraint(item: self.upperLabel, attribute: .Top, relatedBy: .Equal, toItem: self, attribute: .Top, multiplier: 1.0, constant: 0.0)
        let widthCon = NSLayoutConstraint(item: self.upperLabel, attribute: .Width, relatedBy: .Equal, toItem: self, attribute: .Width, multiplier: 1.0, constant: 0.0)
        let heightCon = NSLayoutConstraint(item: self.upperLabel, attribute: .Height, relatedBy: .Equal, toItem: nil, attribute: .NotAnAttribute, multiplier: 1.0, constant: 50.0)
        let leadingCon = NSLayoutConstraint(item: self.upperLabel, attribute: .Leading, relatedBy: .Equal, toItem: self, attribute: .Leading, multiplier: 1.0, constant: 5.0)
        
        self.upperLabel.addConstraint(heightCon)
        
        self.addConstraint(leadingCon)
        self.addConstraint(topCon)
        self.addConstraint(widthCon)
        
        // placeholder 색상 변경
        let placeholderColor = UIColor(white: 200.0 / 255.0, alpha: 0.8)
        self.attributedPlaceholder = NSAttributedString(string:self.placeholder!, attributes: [NSForegroundColorAttributeName : placeholderColor])
    }

    override func drawRect(rect: CGRect) {
    
        // UITextField 하단의 밑줄 그리기
        let context = UIGraphicsGetCurrentContext()
        CGContextSetLineWidth(context, 1.0)
        let colorSpace = CGColorSpaceCreateDeviceRGB()
        let components: [CGFloat] = [255.0 / 255.0, 255.0 / 255.0, 255.0 / 255.0, 0.5]
        let color = CGColorCreate(colorSpace, components)
        CGContextSetStrokeColorWithColor(context, color)
        
        CGContextMoveToPoint(context, 0.0, CGFloat(CGRectGetHeight(rect) – 1.0))
        
        CGContextAddLineToPoint(context, CGRectGetWidth(rect), CGFloat(CGRectGetHeight(rect) – 1.0))
        CGContextStrokePath(context)
    }
    
    // status에 따라 animation 적용하기
    func changeStatus(status: UTTextFieldStatus) {
        
        UIView.animateWithDuration(0.25, delay: 0.0, options: UIViewAnimationOptions.AllowUserInteraction, animations: { () -> Void in
            
            switch status   {
            case .Normal:
                self.upperLabel.alpha = 0.0
                self.upperLabel.transform = CGAffineTransformIdentity
                break
            case .Input:
                self.upperLabel.alpha = 1.0
                self.upperLabel.transform = CGAffineTransformMakeTranslation(0.0, -14.0)
                break
            }
            
            }) { (finish) -> Void in
                
        }
    }
    
    // placeholder 위치 조정
    override func textRectForBounds(bounds: CGRect) -> CGRect {
        return CGRectMake(CGRectGetMinX(bounds) + 5.0, CGRectGetMinY(bounds) + 8.0, CGRectGetWidth(bounds) – 20.0, CGRectGetHeight(bounds))
    }
    
    // text 위치 조정
    override func editingRectForBounds(bounds: CGRect) -> CGRect {
        return CGRectMake(CGRectGetMinX(bounds) + 5.0, CGRectGetMinY(bounds) + 8.0, CGRectGetWidth(bounds) – 20.0, CGRectGetHeight(bounds))
    }
    
    // 클리어버튼의 위치 조정
    override func clearButtonRectForBounds(bounds: CGRect) -> CGRect {
        var rect = super.clearButtonRectForBounds(bounds)
        rect.origin.y = rect.origin.y + 8.0
        
        return rect
    }
}
