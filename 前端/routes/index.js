var express = require('express');
var router = express.Router();

/* GET home page. */
/*router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});*/
router.get('/', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/index.html');
});
router.get('/register.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/register.html');
});
router.get('/login.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/login.html');
});
router.get('/paymoney.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/payMoney.html');
});
router.get('/order.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/order.html');
});
router.get('/shoppingCart.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/shoppingCart.html');
});
router.get('/user.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/user.html');
});
router.get('/goodsInfo.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/goodsInfo.html');
});
router.get('/store.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/store.html');
});
router.get('/favorites.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/favorites.html');
});
router.get('/myOrder.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/myOrder.html');
});
router.get('/browseHistory.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/browseHistory.html');
});
router.get('/accountAssets.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/accountAssets.html');
});
router.get('/accountSecurity.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/accountSecurity.html');
});
router.get('/comment.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/comment.html');
});
router.get('/orderInfo.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/orderInfo.html');
});
router.get('/proclamation.html', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.sendfile('./views/pages/proclamation.html');
});
module.exports = router;
