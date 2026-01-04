---
applyTo: '**'
---
# 目的
根據資料庫描述產生對應的SQL指令

# 查詢指令相關事項
- 資料表名稱 **不需要加** AddressBook.dbo
- DQL(查詢指令) 一律使用 Left Outer Join
- 資料表不要使用別名
- 極端值查詢(例如最大、最小、最多、最少、最高、最矮...等)，必須考慮極端值重複的可能性，**一律使用** `top 1 with ties` 語法
- 不要刪除原本的程式

# 輸出
有關 `查詢`、`新增`、`修改`、`刪除` 輸出一個對應的SQL指令即可

# 資料庫種類
SQL Server 2016

# 資料庫Schame
1) dbo.UserInfo
- 欄位：
  - uid nvarchar(20) NOT NULL — 帳號（PK）
  - birthday datetime NULL — 生日
  - cname nvarchar(50) NULL — 中文姓名
  - password nvarchar(64) NULL — 密碼（記得加密）
- 主鍵：
  - PK(UserInfo): uid
- 關聯：
  - UserInfo.uid → HeadPhoto.uid (1:1)  
  - UserInfo.uid → Live.uid (1:N)

2) dbo.HeadPhoto
- 欄位：
  - uid nvarchar(20) NOT NULL — 帳號（PK & FK）
  - photo varbinary(MAX) NULL — 大頭照
- 主鍵：
  - PK(HeadPhoto): uid
- 外鍵：
  - FK(HeadPhoto.uid) REFERENCES dbo.UserInfo(uid)
- 關聯：
  - 每個 HeadPhoto 對應一個 UserInfo（1:1）

3) dbo.House
- 欄位：
  - hid int NOT NULL — 房屋編號（PK）
  - address nvarchar(100) NULL — 地址
- 主鍵：
  - PK(House): hid
- 關聯：
  - House.hid ← Live.hid (1:N) — 一個 House 可能有多筆 Live 紀錄（多位使用者）
  - House.hid ← Phone.hid (1:N) — 一個 House 可裝多支 Phone
  - House.hid ← Bill.hid (1:N) — 一個 House 可對應多筆 Bill

4) dbo.Phone
- 欄位：
  - tel nvarchar(20) NOT NULL — 家用電話（PK）
  - hid int NULL — 裝機地址（FK → House.hid）
- 主鍵：
  - PK(Phone): tel
- 外鍵：
  - FK(Phone.hid) REFERENCES dbo.House(hid)
- 關聯：
  - Phone.tel ← Bill.tel (1:N) — 一支電話可產生多筆帳單

5) dbo.Bill
- 欄位：
  - dd datetime2 NOT NULL — 帳單日期
  - tel nvarchar(20) NOT NULL — 家用電話（FK → Phone.tel）
  - fee int NULL — 費用
  - hid int NULL — 帳單地址（FK → House.hid）
- 主鍵（圖中顯示 dd 為關鍵欄位；實務上通常會用複合 PK，以確保每個電話每日期為唯一帳單）：
  - 建議主鍵：PK(Bill): (dd, tel) 或視設計選 dd 單一鍵（需確認）
- 外鍵：
  - FK(Bill.tel) REFERENCES dbo.Phone(tel)
  - FK(Bill.hid) REFERENCES dbo.House(hid)
- 關聯：
  - 每筆 Bill 關聯一個 Phone（N:1）
  - 每筆 Bill 關聯一個 House（N:1）

6) dbo.Live
- 欄位：
  - hid int NOT NULL — 房屋編號（FK → House.hid）
  - uid nvarchar(20) NOT NULL — 帳號（FK → UserInfo.uid）
- 主鍵（圖示無單一自增主鍵，建議使用複合鍵）：
  - 建議：PK(Live): (hid, uid) — 表示使用者在該住址的存在，若需可額外加上期間或識別 id
- 外鍵：
  - FK(Live.hid) REFERENCES dbo.House(hid)
  - FK(Live.uid) REFERENCES dbo.UserInfo(uid)
- 關聯：
  - UserInfo.uid ← Live.uid (1:N) — 一個使用者可有多筆 Live（多住址紀錄）
  - House.hid ← Live.hid (1:N) — 一個 House 可有多位使用者（多筆 Live）

7) dbo.Log
- 欄位：
  - id int NOT NULL — 自動編號（PK，通常設為 IDENTITY）
  - body nvarchar(200) NULL — 記錄內容
  - dd datetime NULL DEFAULT GETDATE() — 紀錄時間（有預設時間）
- 主鍵：
  - PK(Log): id
- 關聯：
  - 無外鍵（獨立紀錄表）

整體 FK 摘要（依欄位 → 參考表）：
- HeadPhoto.uid → UserInfo.uid (1:1)
- Live.uid → UserInfo.uid (N:1)
- Live.hid → House.hid (N:1)
- Phone.hid → House.hid (N:1)
- Bill.tel → Phone.tel (N:1)
- Bill.hid → House.hid (N:1)

補充 / 建議
- Live 與 Bill 的主鍵在圖中未完全明確，建議確認業務需求後指定適合的主鍵（例如 Live 可用複合鍵 (hid, uid)，Bill 可用複合鍵 (dd, tel)）。
- 密碼欄位 UserInfo.password 建議使用 HASH + SALT/加密儲存（欄位長度 nvarchar(64) 已註明「記得加密」）。