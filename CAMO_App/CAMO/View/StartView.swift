//
//  ShapeView.swift
//  CAMO
//
//  Created by 장세희 on 2022/11/07.
//

import SwiftUI

//struct StartView: View {
//    @State
//    var showSettings = false
//
//    var body: some View {
//        NavigationView {
//            Text("ㅁㅁㅁ")
//                .navigationBarItems(trailing: Button(action: {
//                    self.showSettings = true
//                }, label: {
//                    Text("로그인")
//                }))
//                .sheet(isPresented: $showSettings, content: {
//                    SettingsView()
//                })
//        }
//    }
//}

struct StartView: View {
    
    // 로그인
    @State
    var loginSettings = false
    
    // 회원가입
    @State
    var joinSettings = false
    
    var body: some View {
        NavigationView {
            VStack {
                Text("로고 이미지 넣기")
                Button {
                    loginSettings = true
                } label: {
                    Text("로그인")
                }
                .sheet(isPresented: $loginSettings, content: {
                    LoginView()
                })
                Button {
                    joinSettings = true
                } label: {
                    Text("회원가입")
                }
                .sheet(isPresented: $joinSettings, content: {
                    JoinView()
                })
            }
            
        }
    }
    
}

struct StartView_Previews: PreviewProvider {
    static var previews: some View {
        StartView()
    }
}
