---
agent: edit
---

# 資料庫結構
[參考](../instructions/sql.instructions.md)

# 目的
建立使用者註冊的 sp

# sp 名稱
register

# 輸入參數
- 帳號
- 密碼
- 姓名 (預設null)
- 生日 (預設null)

# 傳回結果
以資料集的方式傳回，
內容為`註冊成功`/`帳號重複`，
欄位名稱為`result`