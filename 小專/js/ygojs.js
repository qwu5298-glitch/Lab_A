// 分頁
function showPage(pageId) {
    // 隱藏所有頁面
    document.querySelectorAll('.page').forEach(page => page.style.display = 'none');
    // 顯示指定頁面
    document.getElementById(pageId).style.display = 'block';
}

// 音樂
function showmusic(musicId) {
    // 隱藏所有頁面
    document.querySelectorAll('.music').forEach(music => music.style.display = 'none');
    // 顯示指定頁面
    document.getElementById(musicId).style.display = 'block';
}

// 留言板
document.getElementById('messageForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const name = document.getElementById('username').value;
    const msg = document.getElementById('message').value;
    const time = new Date().toLocaleString();

    const post = document.createElement('div');
    post.classList.add('post');
    post.innerHTML = `<strong>${name}</strong> <small>於 ${time}</small><p>${msg}</p>`;

    document.getElementById('messageList').prepend(post);

    // 清空欄位
    this.reset();
});

// 選單
function myFunction(x) {
  x.classList.toggle("change");
}
