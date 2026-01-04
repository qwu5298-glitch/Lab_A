---
agent: edit
---

# 資料庫結構
[參考](../instructions/sql.instructions.md)

# 目的
建立sp，檢查使用者帳號密碼是否正確。

# sp 名稱
login

# 輸入參數
- 帳號
- 密碼

# 傳回結果
以資料集的方式傳回，
內容為`登入成功`/`登入失敗`，
欄位名稱為`result`